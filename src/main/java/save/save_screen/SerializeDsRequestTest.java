package save.save_screen;

import entities.character.Player;
import entities.dungeon.Dungeon;
import org.junit.Test;
import save.save_use_case.DsGateway;
import save.save_use_case.DsRequest;
import save.save_use_case.LoadRequest;
import settings.Initializer;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class SerializeDsRequestTest {

    private Initializer initializer = new Initializer();

    private String databasePath = "./gamesavedb";

    private DsGateway saveFiles;

    private static final double DELTA = 1e-15;

    @Test
    public void SerializeDsRequest() {
        initializer.init();

        try {
            saveFiles = new GameFiles(databasePath);
        }
        catch (IOException e) {
            throw new RuntimeException("Fail to create file!");
        }
        Player player = initializer.getPlayer();
        // construct the dungeon
        Dungeon dungeon = new Dungeon();
        dungeon.generateDungeonMap();

        // construct a save request to the database
        String gameSaveName = "New Save 1";
        LocalDateTime creationTime = LocalDateTime.now();
        DsRequest dsRequest = new DsRequest(gameSaveName, player, dungeon, creationTime);

        // write save request into the database
        saveFiles.save(dsRequest);

        // suppose the user closes the game afterwards, and he wants to load his last save file "New Save 1"
        DsGateway loadedSaveFiles;
        try {
            loadedSaveFiles = new GameFiles(databasePath);
        }
        catch (IOException e) {
            throw new RuntimeException("Fail to create file!");
        }

        // construct a load request to the database
        LoadRequest loadRequest = new LoadRequest(gameSaveName);
        DsRequest loadedSaves = loadedSaveFiles.load(loadRequest);

        // construct another save
        String gameSaveName2 = "New Save 2";
        LocalDateTime creationTime2 = LocalDateTime.now();
        DsRequest dsRequest2 = new DsRequest(gameSaveName2, player, dungeon, creationTime2);
        loadedSaveFiles.save(dsRequest2);

/*        DungeonRoom startingRoom = dsRequest.getDungeon().getStartingRoom();
        DungeonRoom loadedStartingRoom = loadedSaves.getDungeon().getStartingRoom();
        DungeonRoom[] connection = dsRequest.getDungeon().getMap().get(startingRoom).toArray(new DungeonRoom[0]);
        DungeonRoom[] loadedConnection = dsRequest.getDungeon().getMap().get(loadedStartingRoom).toArray(new DungeonRoom[0]);
        System.out.println(connection);*/

        assertEquals("File Name does not Match!", dsRequest.getFileName(), loadedSaves.getFileName());
        assertEquals("Dungeon difficulty field does not match!", 0, Double.compare(dsRequest.getDungeon().getDifficulty(), loadedSaves.getDungeon().getDifficulty()));
        //assertTrue("Dugeon map key set does not match!", dsRequest.getDungeon().getMap().keySet().equals(loadedSaves.getDungeon().getMap().keySet()));
    }
}
