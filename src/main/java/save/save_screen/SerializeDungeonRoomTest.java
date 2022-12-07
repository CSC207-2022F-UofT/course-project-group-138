package save.save_screen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.dungeon.Dungeon;
import entities.dungeon.DungeonRoom;
import org.junit.Test;
import save.CustomizedJsonSerializer.GsonDungeonRoom;

public class SerializeDungeonRoomTest {
    private Dungeon dungeon = new Dungeon();

    @Test
    public void SerializDungeonRoom() {
        System.out.println("gsonStr");
        DungeonRoom dungeonRoom = dungeon.getStartingRoom();
        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(DungeonRoom.class, new GsonDungeonRoom());
        Gson gson = gsonBuilder.create();
        String gsonStr = gson.toJson(dungeonRoom);
        System.out.println(gsonStr);
        assert 1 == 1;
    }
}
