package UI.presenters;

import controllers.StateManager;
import settings.Settings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel{
    StateManager stateManager;
    BufferedImage gameCanvas;
    Graphics2D g2;
    int acc = 0;
    public GamePanel(StateManager stateManager){
        super();
        this.stateManager = stateManager;
        this.setPreferredSize(new Dimension(Settings.getFrameWidth(), Settings.getFrameHeight()));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true); // To improve rendering
        // Canvas to draw on (Buffered image) instead of drawing to Graphics directly
        this.gameCanvas = new BufferedImage(Settings.canvasWidth(), Settings.canvasHeight(),
                BufferedImage.TYPE_INT_ARGB);
        // Use this strategy for easy tile conversion
        this.g2 = (Graphics2D) gameCanvas.getGraphics();
    }
    public void drawCanvas(){
        stateManager.renderState(g2);
    }
    public void drawScreen(){
        Graphics graphics = getGraphics();
        graphics.drawImage(gameCanvas, 0, 0, Settings.getFrameWidth(), Settings.getFrameHeight(), null);
        graphics.dispose();
    }
//    protected void paintComponent(Graphics graphics){
//        super.paintComponent(graphics);
//        Graphics2D graphics2D = (Graphics2D) graphics;
//        stateManager.renderState(graphics2D);
//        graphics2D.dispose();
//    }
}
