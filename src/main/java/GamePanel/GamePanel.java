package GamePanel;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    final int originalSize = 16;
    final int scale = 4;
    final int tileSize = originalSize * scale;
    final int row = 12;
    final int col = 16;
    final int screenWidth = tileSize * col;
    final int screenHeight = tileSize * row;

    Thread gameThread;
    public GamePanel () {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(0x12345));
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        //while loop for game loop

    }





}
