package entities.dungeon;

import entities.character.Enemy;
import entities.inventory.Armor;
import entities.inventory.Inventory;
import entities.inventory.Weapon;
import entities.character.Merchant;
import settings.Settings;

import java.util.Random;

public class DungeonRoomBuilder {
    static int[] ENEMY_WEAPON_RANGE = {5, 25};
    static int[] ENEMY_ARMOR_RANGE = {20, 50};
    static int[] ENEMY_HEALTH_RANGE = {75, 150};
    static double[] ENEMY_MULTIPLIER = {0.75, 1.0, 1.5, 2.0};
    private final int numberOfMerchants;
    private final int numberOfEnemies;
    private int merchantsAdded;
    private int enemiesAdded;
    final private Random rand;

    public DungeonRoomBuilder(int numberOfEnemies, int numberOfMerchants) {
        this.numberOfEnemies = numberOfEnemies;
        this.numberOfMerchants = numberOfMerchants;
        this.enemiesAdded = 0;
        this.merchantsAdded = 0;
        this.rand = new Random();
    }

    /**
     * Builds a new DungeonRoom and randomly inserts either a Merchant, an Enemy or no NPC;
     *
     * @return the new DungeonRoom.
     */
    public DungeonRoom buildNewRoom() {
        DungeonRoom newRoom = new DungeonRoom();
        int[] dungeonRoomSize = Settings.getRoomSize();
        int difficulty = Settings.getDifficulty();

        int insertRandomNPC = this.rand.nextInt(3);              // 0 = Enemy, 1 = Merchant, 2 = None
        switch (insertRandomNPC) {
            case 0:
                if (this.enemiesAdded < numberOfEnemies) {
                    /*
                    enemyAttackPower and enemyArmorDurability pick random values in the following ways:
                        (1) Random.nextInt() picks a random number between 0 and the difference of the minimum and
                            maximum values of their ranges (both ends inclusive).
                        (2) The minimum value of their respective ranges is added to these numbers to bring them within
                            the ranges.
                        (3) enemyAttackPower has the added step of multiplying this final number (within its range)
                            with a difficulty multiplier (based on game difficulty) and then rounding it off.
                     */
                    int enemyAttackPower = (int)Math.round((this.rand.nextInt(ENEMY_WEAPON_RANGE[1] - ENEMY_WEAPON_RANGE[0] + 1) + ENEMY_WEAPON_RANGE[0]) * ENEMY_MULTIPLIER[difficulty]);
                    int enemyArmorDurability = this.rand.nextInt(ENEMY_ARMOR_RANGE[1] - ENEMY_ARMOR_RANGE[0] + 1) + ENEMY_ARMOR_RANGE[0];
                    Inventory enemyInventory = new Inventory(100, new Weapon(enemyAttackPower), new Armor(enemyArmorDurability));

                    int enemyHealth = this.rand.nextInt(ENEMY_HEALTH_RANGE[1] - ENEMY_HEALTH_RANGE[0] + 1) + ENEMY_HEALTH_RANGE[0];

                    int enemyX = rand.nextInt(dungeonRoomSize[0]);
                    int enemyY = rand.nextInt(dungeonRoomSize[1]);

                    newRoom.addNPC(new Enemy(enemyInventory, enemyHealth, enemyX, enemyY));
                    this.enemiesAdded++;
                }
                break;
            case 1:
                if (this.merchantsAdded < this.numberOfMerchants) {
                    int randomItem = this.rand.nextInt(2);       // 0 = Armour, 1 = Weapon

                    int merchantX = rand.nextInt(dungeonRoomSize[0]);
                    int merchantY = rand.nextInt(dungeonRoomSize[1]);
                    if (randomItem == 0) {
                        newRoom.addNPC(new Merchant("Armor", 20, merchantX, merchantY));
                    } else {
                        newRoom.addNPC(new Merchant("Weapon", 30, merchantX, merchantY));
                    }
                    this.merchantsAdded++;
                }
                break;
            case 2:
                break;
        }
        return newRoom;
    }
}
