package settings;

import java.awt.*;

public class Settings {
    /**
     * This is a container class which holds all needed data about the game. Makes everything more organized, easier to
     * test, etc.
     */
    private static int PLAYER_SIZE, PLAYER_SPEED, MAX_HP, EQUIPMENT_ATTRIBUTE_RANGE, PRICE_RANGE, FRAME_WIDTH,
            FRAME_HEIGHT, DIFFICULTY, ENEMY_SIZE, MERCHANT_SIZE, DEFAULT_PLAYER_WEAPON, DEFAULT_PLAYER_ARMOR;
    private static int[] INITIAL_POSITION, ROOM_SIZE;
    private static String gameName;
    private static Image playerImage;

    /**
     * Setters
     */
    public static void setMaxHp(int maxHp) {
        MAX_HP = maxHp;                                                     // TODO: Add description
    }

    public static void setGameName(String name) {
        gameName = name;                                                    // TODO: Add description
    }

    public static void setPlayerSize(int playerSize) {
        PLAYER_SIZE = playerSize;                                           // TODO: Add description
    }

    public static void setPlayerSpeed(int playerSpeed) {
        PLAYER_SPEED = playerSpeed;                                         // TODO: Add description
    }

    public static void setAttributeRange(int attributeRange) {
        EQUIPMENT_ATTRIBUTE_RANGE = attributeRange;                         // TODO: Add description
    }

    public static void setPriceRange(int priceRange) {
        PRICE_RANGE = priceRange;                                           // TODO: Add description
    }

    public static void setInitialPosition(int x, int y) {
        INITIAL_POSITION = new int[]{x, y};                                 // TODO: Add description
    }

    public static void setFrameWidth(int frameWidth) {
        FRAME_WIDTH = frameWidth;                                           // TODO: Add description
    }

    public static void setFrameHeight(int frameHeight) {
        FRAME_HEIGHT = frameHeight;                                         // TODO: Add description
    }

    public static void setPlayerImage(Image image) {
        playerImage = image;                                                // TODO: Add description
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

    public static int getPlayerSize() {
        return PLAYER_SIZE;
    }

    public static int getPlayerSpeed() {
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

    public static int getFrameWidth() {
        return FRAME_WIDTH;
    }
    public static int getFrameHeight() {
        return FRAME_HEIGHT;
    }

    public static String getGameName() {
        return gameName;
    }

    public static Image getPlayerImage() {
        return playerImage;
    }

    public static int[] getRoomSize() {
        return ROOM_SIZE;
    }

    public static int getDifficulty() {
        return DIFFICULTY;
    }

    public static int getDefaultPlayerWeapon() {
        return DEFAULT_PLAYER_WEAPON;
    }

    public static int getDefaultPlayerArmor() {
        return DEFAULT_PLAYER_ARMOR;
    }
}
