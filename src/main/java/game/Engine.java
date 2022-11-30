package game;

import presenters.GameWindow;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Engine {
    /**
     * This class will contain the main game loop.
     */
    private static Thread loop;
    private static boolean isRunning;
    private static StateManager stateManager;
    private static GameWindow gameWindow;
    private static JPanel gamePanel; // temp for now

    /**
     * Should be called after Engine instantiation.
     */
    public void onCreate(){
        stateManager = new StateManager();
        gameWindow = new GameWindow();
    }

    /**
     * Starts the 'Engine', starts the loop.
     */
    public static void start(){
        isRunning = true;
        // @TODO Should start on MenuState whenever that is implemented.
        stateManager.setCurrState(new CrawlingState());
        gameWindow.addGamePanel(gamePanel); // change argument to new GamePanel() when that class is done
        gameWindow.addKeyListener(new Keyboard());
        gameWindow.createGameWindow();
        gameLoop();
        loop.start();
    }
    /**
     * Will use put game loop in a separate thread to avoid clogging Event Dispatch Thread. GUI/UI calls
     * may require SwingUtilities.invokeLater since we are no longer on EDT.
     */
    private static void gameLoop(){
        loop = new Thread(()-> {
            while (isRunning){
                // looping stuff goes here
                loopActions();
                // Sleep this thread for 15ms in case CPU is omega powerful. (however might sleep for 5-20ms)
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    private static void loopActions(){
        stateManager.loop();
    }

    /**
     * End the game loop.
     */
    public void end(){
        isRunning = false;
    }

    // Keyboard actions
    private static class Keyboard implements KeyListener {
        @Override
        public void keyTyped(KeyEvent arg0) {
            // don't need this
        }

        @Override
        public void keyPressed(KeyEvent e) {
            stateManager.keyPressed(e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            stateManager.keyReleased(e.getKeyCode());
        }
    }

}
