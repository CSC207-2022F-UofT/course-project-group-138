package tests;

import character.Player;
import inventory.Armor;
import inventory.Inventory;
import inventory.Weapon;
import settings.Settings;

import java.util.Random;

public class SamplePlayer {
    /**
     * Helper class for writing tests that use a Player attribute.
     */
    private Player player;
    private Random random;

    /**
     * Makes a player with the following initial attributes:
     * Wepon: attack 1, price 2
     * Armor: attack 3, price 4
     * Coins: 0
     */
    public Player samplePlayer() {
        Weapon weapon = new Weapon(1, 2);
        Armor armor = new Armor(3, 4);
        Inventory inv = new Inventory(weapon, armor, 0);
        player = new Player(inv, Settings.getMaxHp(), Settings.getInitialPosition()[0],
                Settings.getInitialPosition()[1]);

        return player;
    }
}
