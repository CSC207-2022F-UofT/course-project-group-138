package controllers.game;

import UI.presenters.GameWindow;
import controllers.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

public class TimerLoopStrategy {
    static StateManager gameStateManager;
    static GameWindow gameWindow;
    Timer timer;
    public TimerLoopStrategy(StateManager gameStateManager, GameWindow gameWindow){
        this.gameStateManager = gameStateManager;
        this.gameWindow = gameWindow;
    }
    public Timer initTimer(){
        timer = new Timer(15, new Loop());
        return timer;
    }
    private static class Loop implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            gameStateManager.loop();
            gameWindow.update();
        }
    }
}
