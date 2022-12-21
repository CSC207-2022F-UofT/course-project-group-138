package save.serialize_test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.character.Enemy;
import entities.character.Merchant;
import entities.character.Player;
import entities.dungeon.Dungeon;
import entities.dungeon.DungeonRoom;
import entities.inventory.Armor;
import entities.inventory.Inventory;
import entities.inventory.Weapon;
import org.junit.Test;
import save.CustomizedJsonDeserializer.GsonDungeonMapDeserializer;
import save.CustomizedJsonDeserializer.GsonDungeonRoomDeserializer;
import save.CustomizedJsonSerializer.GsonDungeonMapSerializer;
import save.CustomizedJsonSerializer.GsonDungeonRoomSerializer;
import settings.Initializer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SerializeDungeonRoomTest {
    private Dungeon dungeon = new Dungeon();
    private GsonBuilder gsonBuilder = new GsonBuilder();

    @Test
    public void SerializeDungeonRoom() {
        System.out.println("gsonStr");
        Initializer initializer = new Initializer();
        initializer.init();
        dungeon.generateDungeonMap();
        List<DungeonRoom> connectedRooms = dungeon.getConnections(dungeon.getStartingRoom());

        gsonBuilder.registerTypeAdapter(DungeonRoom.class, new GsonDungeonRoomSerializer())
                .registerTypeAdapter(Dungeon.saveDungeon().getClass(), new GsonDungeonMapSerializer());

        Gson gson = gsonBuilder.create();

        StringBuilder sbd = new StringBuilder();
        for (DungeonRoom room : connectedRooms) {
            String gsonStr = gson.toJson(room);
            sbd.append(gsonStr);
            System.out.println(gsonStr);
/*            if (room.hasNPC()) {
                Object obj = null;
                try{
                    obj = room.getNPC();
                } catch (Exception ignore) {}
                int armorStat = ((Enemy) obj).getArmorDurability();
                System.out.println(armorStat);
            }*/

        }
        System.out.println(sbd);
    }

    @Test
    public void SerializeDungeonRoom1() {
        DungeonRoom startingRoom = new DungeonRoom();

        DungeonRoom dungeonRoom1 = new DungeonRoom();
        dungeonRoom1.addMerchant(new Merchant("Armor", 20, 1, 5));

        DungeonRoom dungeonRoom2 = new DungeonRoom();
        Inventory enemyInventory = new Inventory(100, new Weapon(2), new Armor(3));
        dungeonRoom2.addEnemy(new Enemy(enemyInventory, 5, 2, 3));

        dungeonRoom2.setPreviousRoom(dungeonRoom1);
        dungeonRoom1.setPreviousRoom(startingRoom);


        gsonBuilder.registerTypeAdapter(DungeonRoom.class, new GsonDungeonRoomSerializer())
                .registerTypeAdapter(Dungeon.saveDungeon().getClass(), new GsonDungeonMapSerializer());

        Gson gson = gsonBuilder.create();


        String gsonStr = gson.toJson(startingRoom);
        System.out.println(gsonStr);
        String gsonStr1 = gson.toJson(dungeonRoom1);
        System.out.println(gsonStr1);
        String gsonStr2 = gson.toJson(dungeonRoom2);
        System.out.println(gsonStr2);

        DungeonRoom loadedStartingRoom = gson.fromJson(gsonStr, DungeonRoom.class);
        DungeonRoom loadedDungeonRoom1 = gson.fromJson(gsonStr1, DungeonRoom.class);
        DungeonRoom loadedDungeonRoom2 = gson.fromJson(gsonStr2, DungeonRoom.class);

        assert loadedDungeonRoom2.hasPreviousRoom() == dungeonRoom2.hasPreviousRoom();
    }
    @Test
    public void SerializeDungeonMap() {
        Initializer initializer = new Initializer();
        initializer.init();
        dungeon.generateDungeonMap();

        gsonBuilder.registerTypeAdapter(DungeonRoom.class, new GsonDungeonRoomSerializer())
                .registerTypeAdapter(DungeonRoom.class, new GsonDungeonRoomDeserializer())
                .registerTypeAdapter(Dungeon.saveDungeon().getClass(), new GsonDungeonMapSerializer())
                .registerTypeAdapter(Dungeon.saveDungeon().getClass(), new GsonDungeonMapDeserializer());

        Gson gson = gsonBuilder.create();
        String gsonStr = gson.toJson(dungeon);

        Dungeon loadedDungeon =gson.fromJson(gsonStr, Dungeon.class);
        String gsonStr2 = gson.toJson(loadedDungeon);

        BufferedWriter writer;
        try{
            writer  = new BufferedWriter(new FileWriter("./dungeonmaptest"));
            writer.write(gsonStr);
            writer.newLine();
            writer.write(gsonStr2);
            writer.newLine();
            writer.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(gsonStr2.length());
        System.out.println(gsonStr.length());

        assertTrue(gsonStr2.length() == gsonStr.length());

    }

    @Test
    public void SerializeMerchant() {
        Merchant merchant = new Merchant("Armor", 20, 1, 5);
        Gson gson = new Gson();
        String gsonStr = gson.toJson(merchant);
        System.out.println(gsonStr);
    }

    @Test
    public void SerializePlayer() {
        Initializer initializer = new Initializer();
        initializer.init();
        Player player = initializer.getPlayer();
        Gson gson = new Gson();
        String gsonStr = gson.toJson(player);
        System.out.println(gsonStr);
    }
}
