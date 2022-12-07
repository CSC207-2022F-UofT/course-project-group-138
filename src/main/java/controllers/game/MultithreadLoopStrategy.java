package controllers.game;

import settings.Settings;

import static controllers.game.Engine.loopActions;

public class MultithreadLoopStrategy {
    boolean isRunning;
    Thread loop;
    public void start(){
        isRunning = true;
        initThread();
        loop.start();
    }
    public void end(){
        isRunning = false;
    }
    /**
     * Will use put game loop in a separate thread to avoid clogging Event Dispatch Thread. GUI/UI calls
     * may require SwingUtilities.invokeLater since we are no longer on EDT.
     */
    public void initThread(){
        /**
         * Currently shows FPS for debugging on MacOS. @TODO remove later
         */
        loop = new Thread(()-> {
            double interval = 1_000_000_000 / Settings.getFPS(); // time in nano seconds for 1/fps
            double delta = 0;
            long lastTime = System.nanoTime();
            long currTime;
            long timer = 0;
            int drawCount = 0;
            while (isRunning){
                currTime = System.nanoTime();
                delta += (currTime - lastTime) / interval;

                timer += (currTime - lastTime);

                lastTime = currTime;

                if (delta >= 1){ // meaning that it has reached the time interval required to be under FPS
                    loopActions();
                    delta--;
                    drawCount++;
                }
                if (timer >= 1000000000){
                    System.out.println("Current FPS: " + drawCount);
                    drawCount = 0;
                    timer = 0;
                }
            }
        });
    }
}
