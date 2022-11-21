package GamePanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setVisible(true);
        window.setTitle("Amazing Dungeon Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of app
        window.setResizable(false); //can't resize
        window.setLocationRelativeTo(null); //centered

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack(); //fit the size


        gamePanel.startGameThread(); //will initiate the game loop through the gamepanel class



    }

}

