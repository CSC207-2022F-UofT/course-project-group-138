package controllers.game;

import static controllers.game.Engine.loopActions;

public class MultithreadLoopStrategy {
    boolean isRunning;
    public void start(){
        initThread();
        isRunning = true;
    }
    public void end(){
        isRunning = false;
    }
    public void initThread(){
        Thread loop;
        loop = new Thread(()-> {
            while (isRunning){
                // looping stuff goes here
                loopActions();
                // Sleep this thread for 15ms in case CPU is omega powerful. (however might sleep for 5-20ms)
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
