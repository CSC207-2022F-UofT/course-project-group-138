package UI.GamePanel;

import controllers.StateManager;
import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
    StateManager stateManager;
    public GamePanel(StateManager stateManager){
        super();
        this.stateManager = stateManager;
        this.setPreferredSize(new Dimension(Settings.getFrameWidth(), Settings.getFrameHeight()));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // To improve rendering
    }
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        stateManager.renderState(graphics2D);
    }

}
