package game;

public class Engine {
    /**
     * This class will contain the main game loop.
     */
    private static Thread loop;
    private static boolean isRunning;
    public static void start(){
        loop.start();
    }

    /**
     * Will use put game loop in a separate thread to avoid clogging Event Dispatch Thread. GUI/UI calls
     * may require SwingUtilities.invokeLater since we are no longer on EDT.
     */
    private void gameLoop(){
        loop = new Thread(()-> {
            while (isRunning){
                // looping stuff goes here
                loopActions();

                // Sleep this thread for 15ms in case CPU is omega powerful. (however might sleep for 5-20ms)
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    private void loopActions(){
        //@TODO add loop stuff
    }


}
