package settings;

public class Settings {
    /**
     * This is a container class which holds all needed data about the game. Makes everything more organized, easier to
     * test, etc.
     */
    private static int PLAYER_SIZE, PLAYER_SPEED, MAX_HP, EQUIPMENT_ATTRIBUTE_RANGE, PRICE_RANGE, FRAME_WIDTH, FRAME_HEIGHT;
    private static int[] INITIAL_POSITION;
    private static String gameName;
    public static void setMaxHp(int maxHp){
        MAX_HP = maxHp;
    }
    public static void setGameName(String name){
        gameName = name;
    }
    public static void setPlayerSize(int playerSize){
        PLAYER_SIZE = playerSize;
    }
    public static void setPlayerSpeed(int playerSpeed){
        PLAYER_SPEED = playerSpeed;
    }
    public static void setAttributeRange(int attributeRange) {EQUIPMENT_ATTRIBUTE_RANGE = attributeRange;}
    public static void setPriceRange(int priceRange) {PRICE_RANGE = priceRange;}
    public static void setInitialPosition(int x, int y) {INITIAL_POSITION = new int[]{x, y};}

    public static void setFrameWidth(int frameWidth){
        FRAME_WIDTH = frameWidth;}
    public static void setFrameHeight(int frameHeight){
        FRAME_HEIGHT = frameHeight;}
    public static int getMaxHp(){
        return MAX_HP;
    }
    public static int getPlayerSize(){
        return PLAYER_SIZE;
    }
    public static int getPlayerSpeed(){
        return PLAYER_SPEED;
    }
    public static int getAttributeRange() {return EQUIPMENT_ATTRIBUTE_RANGE;}
    public static int getPriceRange() {return PRICE_RANGE;}
    public static int[] getInitialPosition() {return INITIAL_POSITION;}


    public static int getFrameWidth(){return FRAME_WIDTH;}
    public static int getFrameHeight(){return FRAME_HEIGHT;}
    public static String getGameName(){return gameName;}
}
