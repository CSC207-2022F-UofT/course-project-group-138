package GamePanel;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    private final int originalSize = 16;
    private final int scale = 4;
    private final int tileSize = originalSize * scale;
    private final int row = 12;
    private final int col = 16;
    final int screenWidth = tileSize * col;
    final int screenHeight = tileSize * row;

    KeyInteractor keyInteractor = new KeyInteractor();
    Thread gameThread; // a thread where you can start or stop.

    //FPS
    int FPS = 60;

    //Player's default position
    static int playerX = 100;
    static int playerY = 100;
    static int playerSpeed = 4; //if hit the key, the character moves by four pixels

    public GamePanel () {
//        System.out.println("123");
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(0x12345));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyInteractor);
        this.setFocusable(true); //this GamePanel can recieve key input
        this.requestFocusInWindow();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // implement the gamethread.

        // apply sleep method

        double drawInterval = 1000000000 / FPS; // .01666 seconds since 1*10^9 nano sec = 1 second
        double nextDrawTime = System.nanoTime() + drawInterval; //when hit, draw again

        while (gameThread != null){

            //while loop for game loop

            // long currentTime = System.nanoTime(); to check the initial time before the update
            // and repaint functions. Use nano second to check the time, more precise.

            update();
            repaint(); // call the paintComponent method.

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                } // if update and repaint method took more than the interval, we don't need sleep.

                Thread.sleep((long) remainingTime); //sleep, temp pause the game loop
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void update(){
//        System.out.println(keyInteractor);
        if (keyInteractor.upPressed){
            playerY -= playerSpeed;
        }
        if (keyInteractor.downPressed){
            playerY += playerSpeed;
        }
        if (keyInteractor.leftPressed){
            playerX -= playerSpeed;
        }
        if (keyInteractor.rightPressed){
            playerX += playerSpeed;
        }

    }

    //built-in method to be called by the game loop, repaint() method
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();

    }





}
