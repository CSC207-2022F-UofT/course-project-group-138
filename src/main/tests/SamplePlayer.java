import entities.character.Player;
import entities.inventory.Armor;
import entities.inventory.Inventory;
import entities.inventory.Weapon;
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
     * Wepon: attack 1
     * Armor: durability 3
     * Coins: 0
     */
    public Player samplePlayer() {
        Weapon weapon = new Weapon(1);
        Armor armor = new Armor(3);
        Inventory inv = new Inventory(0, weapon, armor);
        player = new Player(inv, Settings.getMaxHp(), Settings.getInitialPosition()[0],
                Settings.getInitialPosition()[1]);

        return player;
    }
}
