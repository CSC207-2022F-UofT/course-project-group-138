package UI.GamePanel;

import javax.swing.*;
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setTitle("Amazing Dungeon Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of app

        GamePanel gamePanel = new GamePanel();
        gamePanel.startGameThread(); //will initiate the game loop through the gamepanel class

        window.add(gamePanel);
        window.pack(); //fit the size

        window.setResizable(false); //can't resize
        window.setLocationRelativeTo(null);
        window.setVisible(true);


    }

}

