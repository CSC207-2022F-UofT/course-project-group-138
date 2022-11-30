package UI.GamePanel;

import controllers.gameStates.StateManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
    StateManager stateManager;
    public GamePanel(StateManager stateManager){
        super();
        this.stateManager = stateManager;
    }
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        stateManager.renderState(graphics);
        repaint();
    }

}
