package save.save_screen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.character.Player;
import entities.dungeon.Dungeon;
import org.junit.Test;
import save.save_use_case.DsRequest;
import settings.Initializer;

import java.time.LocalDateTime;

public class SerializeDsRequestTest {


    @Test
    public void SerializeDsrequest() {
/*
        Settings.setPriceRange(3);
        Settings.setAttributeRange(3);
        Settings.setMaxHp(3);
        Settings.setPlayerSpeed(12);
        // Sets Window size based on monitor resolution
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Settings.setFrameWidth((int) d.getWidth());
        Settings.setFrameHeight((int) d.getHeight());
        Settings.determineScalingFactor();
        Settings.centerInitialPosition();
        Settings.setRoomSize(Settings.getFrameWidth(), Settings.getFrameHeight());


        // construct a player
        CharacterCreator characterCreator = new CommonCharacterCreator();
        Player player = characterCreator.createPlayer(100,
                Settings.getDefaultPlayerWeapon(),
                Settings.getDefaultPlayerArmor(),
                Settings.getMaxHp(),
                6,
                1);
*/

        Initializer initializer = new Initializer();
        initializer.init();
        Player player = initializer.getPlayer();
        // construct the dungeon
        Dungeon dungeon = new Dungeon();
        dungeon.generateDungeonMap();

        // construct a save request to the database
        String gameSaveName = "New Save 1";
        LocalDateTime creationTime = LocalDateTime.now();
        DsRequest dsRequest = new DsRequest(gameSaveName, player, dungeon, creationTime);

        String databasePath = "./gamesavedb";
/*        DsGateway saveFiles;
        try {
            saveFiles = new GameFiles(databasePath);
        }
        catch (IOException e) {
            throw new RuntimeException("Fail to create file!");
        }*/

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(dungeon.getStartingRoom().getClass(), new GsonConnectedRooms());
        Gson gson = gsonBuilder.create();
        System.out.println("reached");
        //String str = gson.toJson(dsRequest);
        System.out.println(gson.toJson(dungeon.getStartingRoom()));

        /*BufferedWriter writer;
        try{
            writer = new BufferedWriter(new FileWriter(databasePath));
            writer.write("123");
            writer.newLine();

            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }*/

    }
}
