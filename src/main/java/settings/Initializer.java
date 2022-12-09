package settings;

import entities.character.Player;
import entities.dungeon.Dungeon;
import entities.dungeon.DungeonRoom;
import entities.inventory.Armor;
import entities.inventory.Inventory;
import entities.inventory.Weapon;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Initializer {
    private static Player player;
    private Random random = new Random();

    public void init() {
        // below are temporary. @TODO change later
        Settings.setPriceRange(3);
        Settings.setAttributeRange(3);
        Settings.setMaxHp(3);
        Settings.setPlayerSpeed(9);
        // Sets Window size based on monitor resolution
        Dimension d = getScreenSize();
        Settings.setFrameWidth((int) d.getWidth());
        Settings.setFrameHeight((int) d.getHeight());
        Settings.determineScalingFactor();
        Settings.centerInitialPosition();
        Settings.setRoomSize(Settings.getFrameWidth(), Settings.getFrameHeight());

        // Initialize Inventory
        Weapon weapon = new Weapon(Settings.getDefaultPlayerWeapon());
        Armor armor = new Armor(Settings.getDefaultPlayerArmor());
        Inventory inventory = new Inventory(100, weapon, armor);

        // Initialize player
        player = new Player(inventory, Settings.getMaxHp(), Settings.getInitialPosition()[0],
                Settings.getInitialPosition()[1]);

        //TODO: Call paint program for player, weapon, armor, enemy & merchant
    }
    private Dimension getScreenSize(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
    public static Player getPlayer(){
        return player;
    }
}