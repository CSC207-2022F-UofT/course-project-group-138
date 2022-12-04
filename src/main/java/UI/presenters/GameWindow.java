package UI.presenters;

import settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

public class GameWindow {
    /**
     * This class acts as the main Game Window/UI presenter. It is responsible
     * for the JFrames and JPanels that the user sees
     */
    private final JFrame gameFrame;
    private GamePanel gamePanel;

    /**
     * Constructs a JFrame, which will act as the game's main frame
     */
    public GameWindow(){
        // Alternatively, pass in a JFrame as parameter if this comforms better
        // with Clean Architecture
        gameFrame = new JFrame(Settings.getGameName());
        // maybe add gameFrame.setBounds later. Might be unneccessary though
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        setFullScreen();
//        gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        gameFrame.setUndecorated(true);
        gameFrame.setTitle(Settings.getGameName());
        // Builds a new JFrame that is unresizable and exits on window close
    }

    /**
     * Acts as both a setter for gamePanel and an initializer
     * @param gamePanel - The JPanel containing main game UI
     */
    public void addGamePanel(GamePanel gamePanel){
        // Create a dimension with width, height from Settings
        Dimension d = new Dimension(Settings.getFrameWidth(), Settings.getFrameHeight());
        this.gamePanel = gamePanel;
        this.gamePanel.setPreferredSize(d);
        this.gamePanel.setFocusable(true);
        this.gamePanel.requestFocusInWindow();
    }

    /**
     * Adds the keyboard class created in the Engine module as a keyListener for the
     * gamePanel
     * @param keyListener - A KeyListener to record user key input
     */
    public void addKeyListener(KeyListener keyListener){
        // adds keyListener to the gamePanel
        gamePanel.addKeyListener(keyListener);
    }
    public void update(){
        gamePanel.drawCanvas();
        gamePanel.drawScreen();
        // gamePanel.repaint();
    }
    /**
     * Creates the GameWindow
     */
    public void createGameWindow(){
        gameFrame.add(gamePanel);
        gameFrame.pack();
        gameFrame.setVisible(true);
    }
    private void setFullScreen(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(gameFrame);
    }
    public void close(){
        gameFrame.dispatchEvent(new WindowEvent(gameFrame, WindowEvent.WINDOW_CLOSING));
    }

}
