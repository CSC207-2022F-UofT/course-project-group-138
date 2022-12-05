package settings;

import java.awt.*;

public class Settings {
    /**
     * This is a container class which holds all needed data about the game. Makes everything more organized, easier to
     * test, etc.
     */
    private static int PLAYER_SPEED, MAX_HP, EQUIPMENT_ATTRIBUTE_RANGE, PRICE_RANGE, FRAME_WIDTH,
            FRAME_HEIGHT, DIFFICULTY, ENEMY_SIZE, MERCHANT_SIZE, DEFAULT_PLAYER_WEAPON, DEFAULT_PLAYER_ARMOR;
    private static int ROOM_SIZE_X, ROOM_SIZE_Y;
    private static final int tileSize = 93; // keeping resolution approx 1920 X 1080 p
    private static final int rows = 12; // to keep the 16 x 9 aspect ratio
    private static final int columns = 20;
    private static int PLAYER_SIZE = 75;
    private static int scalingFactor;
    private static int[] INITIAL_POSITION, ROOM_SIZE;
    private static String gameName = "Dungeons";
    private static Image playerImage;

    /**
     * Setters
     */
    public static void setMaxHp(int maxHp) {
        MAX_HP = maxHp;                                                     // TODO: Add description
    }
    public static void setGameName(String name){
        gameName = name;
    }
    public static void setPlayerSize(int playerSize){
        PLAYER_SIZE = playerSize;
    }

    public static void setPlayerSpeed(int playerSpeed) {
        PLAYER_SPEED = playerSpeed;                                         // TODO: Add description
    }

    public static void setAttributeRange(int attributeRange) {
        EQUIPMENT_ATTRIBUTE_RANGE = attributeRange;                         // TODO: Add description
    }
    public static void setPriceRange(int priceRange) {PRICE_RANGE = priceRange;}
    public static void setInitialPosition(int x, int y) {INITIAL_POSITION = new int[]{x, y};}
    public static void determineScalingFactor(){
        // Normalize scalingFactor based on control value (1440 pixels tall)
        scalingFactor = getFrameHeight() / 1440;
    }

    /**
     * Frame width/height must be set before method call to center initial position.
     */
    public static void centerInitialPosition(){setInitialPosition(canvasWidth() / 2, canvasHeight() / 2);}
    public static void setFrameWidth(int frameWidth){
        FRAME_WIDTH = frameWidth;}
    public static void setFrameHeight(int frameHeight){
        FRAME_HEIGHT = frameHeight;}
    public static void setPlayerImage(Image image){
        playerImage = image;
    }

    public static void setRoomSize(int x, int y) {
        ROOM_SIZE[0] = x;                                                   // Height, width of DungeonRoom
        ROOM_SIZE[1] = y;
    }

    public static void setDifficulty(int difficulty) {
        DIFFICULTY = difficulty;                                            // Game difficulty
    }
    public static void setDefaultWeapon(int power) {
        DEFAULT_PLAYER_WEAPON = power;                                      // Default Weapon attack power
    }
    public static void setDefaultArmor(int durability) {
        DEFAULT_PLAYER_ARMOR = durability;                                  // Default Armor durability
    }

    /**
     * Getters
     */
    public static int getMaxHp() {
        return MAX_HP;
    }
    public static int getPlayerSize(){
        return PLAYER_SIZE;
    }
    public static int getPlayerSpeed(){
        return PLAYER_SPEED;
    }

    public static int getAttributeRange() {
        return EQUIPMENT_ATTRIBUTE_RANGE;
    }

    public static int getPriceRange() {
        return PRICE_RANGE;
    }

    public static int[] getInitialPosition() {
        return INITIAL_POSITION;
    }


    public static int getFrameWidth(){return FRAME_WIDTH;}
    public static int getFrameHeight(){return FRAME_HEIGHT;}
    public static String getGameName(){return gameName;}
    public static Image getPlayerImage(){return playerImage;}


    public static int[] getRoomSize() {
//        return ROOM_SIZE;
//    }

    public static int getDifficulty() {
        return DIFFICULTY;
    }

    public static int getDefaultPlayerWeapon() {
        return DEFAULT_PLAYER_WEAPON;
    }

    public static int getDefaultPlayerArmor() {
        return DEFAULT_PLAYER_ARMOR;
    }
    public static int getScalingFactor(){
        return scalingFactor;
    }

    public static int getColumns() {
        return columns;
    }

    public static int getTileSize() {
        return tileSize;
    }

    public static int getRows() {
        return rows;
    }
    public static int canvasWidth(){
        return tileSize * columns; // 1860
    }
    public static int canvasHeight(){
        return tileSize * rows; // 1116
    }
}
