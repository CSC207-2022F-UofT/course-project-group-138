package save.serialize_test;

import entities.character.Player;
import entities.dungeon.Dungeon;
import org.junit.Test;
import save.save_screen.GameFiles;
import save.save_screen.SaveController;
import save.save_screen.UpdateResponse;
import save.save_use_case.*;
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

        // construct the dungeon
        Dungeon dungeon = new Dungeon();
        dungeon.generateDungeonMap();

        try {
            saveFiles = new GameFiles(databasePath);
        }
        catch (IOException e) {
            throw new RuntimeException("Fail to create file!");
        }

        SaveLoadPresenter presenter = new UpdateResponse();
        SaveInputBoundry saveInteractor = new SaveInteractor(saveFiles, presenter);
        SaveController controller = new SaveController(saveInteractor);

        // construct a save request to the database
        String gameSaveName = "New Save 10";
        controller.performSave(gameSaveName);

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

    }
    @Test
    public void MultipleSaves() {
        int numOfSaves = 5;
        for (int i = 1; i <= numOfSaves; i++) {
            initializer.init();

            Dungeon dungeon = new Dungeon();
            dungeon.generateDungeonMap();

            StringBuilder saveName = new StringBuilder("New Save ");
            saveName.append(i);

            try {
                saveFiles = new GameFiles(databasePath);
            } catch (IOException e) {
                throw new RuntimeException("Fail to create file!");
            }

            SaveLoadPresenter presenter = new UpdateResponse();
            SaveInputBoundry saveInteractor = new SaveInteractor(saveFiles, presenter);
            SaveController controller = new SaveController(saveInteractor);
            controller.performSave(saveName.toString());

            DsGateway loadedSaveFiles;
            try {
                loadedSaveFiles = new GameFiles(databasePath);
            }
            catch (IOException e) {
                throw new RuntimeException("Fail to create file!");
            }

            // construct a load request to the database
            LoadRequest loadRequest = new LoadRequest(saveName.toString());
            DsRequest loadedSaves = loadedSaveFiles.load(loadRequest);
        }
    }
}
