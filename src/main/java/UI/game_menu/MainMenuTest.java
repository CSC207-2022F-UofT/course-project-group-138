package UI.game_menu;

import org.junit.Test;
import save.save_screen.GameFiles;
import save.save_use_case.DsGateway;

import javax.swing.*;
import java.io.IOException;

public class MainMenuTest {
    @Test
    public static void main(String[] args) {
/*        JFrame application = new JFrame("Login Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.pack();
        application.setVisible(true);*/
        JFrame gameWindow = new JFrame();
/*        JPanel screens = new JPanel();
        gameWindow.add(screens);

        MainMenuScreen mainMenuScreen = new MainMenuScreen();
        screens.add(mainMenuScreen);*/
        DsGateway dsGateway;
        try {
            dsGateway = new GameFiles("./gamesavesdb");
        } catch (IOException e) {
            throw new RuntimeException("Fail to create file!");
        }

/*        MainMenuScreen mainMenuScreen = new MainMenuScreen();
        gameWindow.add(mainMenuScreen);

        gameWindow.pack();
        gameWindow.setVisible(true);*/
    }
}
