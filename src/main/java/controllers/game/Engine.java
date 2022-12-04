package controllers.game;

import UI.presenters.GamePanel;
import UI.presenters.GameWindow;
import controllers.gameStates.CrawlingState;
import controllers.StateManager;
import settings.Settings;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.atomic.AtomicReference;

public class Engine {
    /**
     * This class will contain the main game loop.
     */
    private static Thread loop;
    private static boolean isRunning;
    private static StateManager stateManager;
    // Below are references to presenters
    private static GameWindow gameWindow;
    private static GamePanel gamePanel;
    private static TimerLoopStrategy timerStrategy;
    private static MultithreadLoopStrategy threadStrategy;
    private static Timer timer;

    /**
     * Should be called after Engine instantiation.
     */
    public static void onCreate(){
        stateManager = new StateManager();
        gamePanel = new GamePanel(stateManager);
        gameWindow = new GameWindow();
//        timerStrategy = new TimerLoopStrategy(stateManager, gameWindow);
//        timer = timerStrategy.initTimer();
        // threadStrategy = new MultithreadLoopStrategy();
    }

    /**
     * Starts the 'Engine', starts the loop.
     */
    public static void start(){
        isRunning = true;
        // @TODO Should start on MenuState whenever that is implemented.
        stateManager.setCurrState(new CrawlingState());
        gameWindow.addGamePanel(gamePanel);
        gameWindow.addKeyListener(new Keyboard());
        gameWindow.createGameWindow();
//        timer.start();
        gameLoop();
        loop.start();
    }
    /**
     * Will use put game loop in a separate thread to avoid clogging Event Dispatch Thread. GUI/UI calls
     * may require SwingUtilities.invokeLater since we are no longer on EDT.
     */
    private static void gameLoop(){

        loop = new Thread(()-> {
            double interval = 1_000_000_000 / Settings.getFPS(); // time in nano seconds for 1/fps
            double delta = 0;
            long lastTime = System.nanoTime();
            long currTime;
            while (isRunning){
                currTime = System.nanoTime();
                delta += (currTime - lastTime) / interval;
                lastTime = currTime;

                if (delta >= 1){ // meaning that it has reached the time interval required to be under FPS
                    loopActions();
                    delta--;
                }
            }
        });
    }

    /**
     * Things to do during the main game loop
     */
    public static void loopActions(){
        stateManager.loop(); // Loops and updates backend game logic
        gameWindow.update(); // Loops and updates frontup UI
    }
    public static void quit(){
        gameWindow.close();
    }
    /**
     * End the game loop.
     */
    public static void end(){
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
