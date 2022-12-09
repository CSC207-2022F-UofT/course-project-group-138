package controllers.game;

import UI.presenters.GamePanel;
import UI.presenters.GameWindow;
import controllers.gameStates.CrawlingState;
import controllers.gameStates.States;
import controllers.StateManager;
import controllers.StateFactory;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class Engine {
    /**
     * This class will contain the main game loop.
     */
    private static StateManager stateManager;
    // Below are references to presenters
    private static GameWindow gameWindow;
    private static GamePanel gamePanel;
    private static TimerLoopStrategy timerStrategy;
    private static MultithreadLoopStrategy threadStrategy;
    private static Timer timer;
    private static final StateFactory stateFactory= new StateFactory();

    /**
     * Should be called after Engine instantiation.
     */
    public static void onCreate(){
        stateManager = new StateManager();
        gamePanel = new GamePanel(stateManager);

        gameWindow = new GameWindow();

        //timerStrategy = new TimerLoopStrategy(stateManager, gameWindow);
        //timer = timerStrategy.initTimer();
        threadStrategy = new MultithreadLoopStrategy();
    }

    /**
     * Starts the 'Engine', starts the loop.
     */
    public static void start(){
        // @TODO Should start on MenuState whenever that is implemented.
        initializeManager();

        gameWindow.addGamePanel(gamePanel);
        gameWindow.addKeyListener(new Keyboard());
        gameWindow.createGameWindow();
        threadStrategy.start();
        //timer.start();
//        gameLoop();
//        loop.start();
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
        threadStrategy.end();
    }
    private static void initializeManager(){

        stateManager.crawlingState = stateFactory.getState(States.CRAWL);
        ((CrawlingState) stateManager.crawlingState).setStateChanger(stateManager);
        stateManager.combatState = stateFactory.getState(States.COMBAT);
        stateManager.menuState = stateFactory.getState(States.MENU);
        stateManager.encounterState = stateFactory.getState(States.MERCHANT);
        stateManager.toCrawlingState();

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

        public void click(MouseEvent e) {
            stateManager.click(e.getID());
        }
    }

}
