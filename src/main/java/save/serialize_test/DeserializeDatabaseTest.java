package save.serialize_test;

import org.junit.Test;
import save.save_screen.GameFiles;
import save.save_screen.LoadController;
import save.save_screen.UpdateResponse;
import save.save_use_case.*;

import java.io.IOException;

public class DeserializeDatabaseTest {

    @Test
    public void readDataBase() {
        DsGateway saveFiles;
        try {
            saveFiles = new GameFiles("./gamesavedb");
        }
        catch (IOException e) {
            throw new RuntimeException("Fail to create file!");
        }

        SaveLoadPresenter presenter = new UpdateResponse();
        LoadInputBoundary loadInteractor = new LoadInteractor(saveFiles, presenter);
        LoadController controller = new LoadController(loadInteractor);

        LoadResponse response = controller.performLoad("k", true);
        System.out.println(response.getFilename());
    }
}
