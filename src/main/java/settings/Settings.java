package settings;

public class Settings {
    /**
     * This is a container class which holds all needed data about the game
     */
    private static int PLAYER_SIZE, PLAYER_SPEED, MAX_HP;

    public static void setMaxHp(int maxHp){
        MAX_HP = maxHp;
    }
    public static void setPlayerSize(int playerSize){
        PLAYER_SIZE = playerSize;
    }
    public static void setPlayerSpeed(int playerSpeed){
        PLAYER_SPEED = playerSpeed;
    }
    public static int getMaxHp(){
        return MAX_HP;
    }
    public static int getPlayerSize(){
        return PLAYER_SIZE;
    }
    public static int getPlayerSpeed(){
        return PLAYER_SPEED;
    }
}
