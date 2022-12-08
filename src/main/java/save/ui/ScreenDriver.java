package save.ui;

import save.save_screen.GameFiles;
import save.save_screen.LoadController;
import save.save_screen.SaveController;
import save.save_screen.UpdateResponse;
import save.save_use_case.*;
import settings.Initializer;

import java.io.IOException;

public class ScreenDriver {
    public void driveSaveScreen() {
/*        JFrame application = new JFrame("Login Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.pack();
        application.setVisible(true);*/
/*        JFrame gameWindow = new JFrame();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        /*
        JPanel screens = new JPanel();
        gameWindow.add(screens);*/

        Initializer initializer = new Initializer();
        initializer.init();

        DsGateway saveFiles;
        try {
            saveFiles = new GameFiles("./gamesavedb");
        }
        catch (IOException e) {
            throw new RuntimeException("Fail to create file!");
        }

        SaveLoadPresenter presenter = new UpdateResponse();
        SaveInputBoundry saveInputBoundry = new SaveInteractor(saveFiles, presenter);
        SaveController controller = new SaveController(saveInputBoundry);

        SaveScreen saveScreen = new SaveScreen(controller);
        saveScreen.buildSaveScreen();
        //screens.add(saveScreen);
/*        gameWindow.add(saveScreen);

        gameWindow.pack();
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);*/

/*        MainMenuScreen mainMenuScreen = new MainMenuScreen();
        gameWindow.add(mainMenuScreen);

        gameWindow.pack();
        gameWindow.setVisible(true);*/
    }

    public void driveLoadScreen() {
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

        LoadScreen loadScreen = new LoadScreen(controller);
        loadScreen.buildLoadScreen();
    }
}
