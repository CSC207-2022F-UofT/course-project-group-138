package save.serialize_test;

import entities.character.Player;
import entities.dungeon.Dungeon;
import org.junit.Test;
import save.save_screen.GameFiles;
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
    public void OneSave() {
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

        assertEquals("File Name does not Match!", dsRequest.getFileName(), loadedSaves.getFileName());
        assertEquals("Dungeon difficulty field does not match!", 0, Double.compare(dsRequest.getDungeon().getDifficulty(), loadedSaves.getDungeon().getDifficulty()));
    }
    @Test
    public void MultipleSaves() {
        int numOfSaves = 5;
        for (int i = 1; i <= numOfSaves; i++) {
            initializer.init();
            Player player = initializer.getPlayer();

            StringBuilder saveName = new StringBuilder("New Save ");
            saveName.append(i);

            Dungeon dungeon = new Dungeon();
            dungeon.generateDungeonMap();

            LocalDateTime creationTime = LocalDateTime.now();

            DsRequest dsRequest = new DsRequest(saveName.toString(), player, dungeon, creationTime);

            try {
                saveFiles = new GameFiles(databasePath);
            } catch (IOException e) {
                throw new RuntimeException("Fail to create file!");
            }

            saveFiles.save(dsRequest);
        }
    }
}
