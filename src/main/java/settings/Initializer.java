package settings;

import character.Player;
import dungeon.Dungeon;
import dungeon.DungeonRoom;
import inventory.Armor;
import inventory.Inventory;
import inventory.Weapon;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Initializer {
    private Dungeon dungeon;
    private HashMap<DungeonRoom, List<DungeonRoom>> map ;
    private Player player;
    private Random random;

    public void init() {
        dungeon = new Dungeon();
        dungeon.generateDungeonMap();

        Weapon weapon = new Weapon(random.nextInt(Settings.getAttributeRange()) + 1,
                random.nextInt(Settings.getPriceRange()) + 1);
        Armor armor = new Armor(random.nextInt(Settings.getAttributeRange()) + 1,
                random.nextInt(Settings.getPriceRange()) + 1);
        Inventory inv = new Inventory(weapon, armor, 0);
        player = new Player(inv, Settings.getMaxHp(), Settings.getInitialPosition()[0],
                Settings.getInitialPosition()[1]);

        //TODO: Call paint program for player, weapon, armor, enemy & merchant
    }
    public Player getPlayer(){
        return player;
    }
    public Dungeon getDungeon(){
        return dungeon;
    }
}
