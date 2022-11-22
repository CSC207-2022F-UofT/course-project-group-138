package dungeon;

import character.Enemy;
import inventory.Armor;
import inventory.Inventory;
import inventory.Weapon;
import character.Merchant;
import settings.Settings;

import java.util.Random;

public class DungeonRoomBuilder {
    static int[] ENEMY_WEAPON_ATTACK_RANGE = {5, 25};
    static double[] ENEMY_MULTIPLIER = {0.75, 1.0, 1.5, 2.0};
    static int[] ENEMY_ARMOR_ATTACK_RANGE = {20, 50};
    private final int numberOfMerchants;
    private final int numberOfEnemies;
    private int merchantsAdded;
    private int enemiesAdded;
    final private Random rand;

    public DungeonRoomBuilder(int numberOfEnemies, int nummberOfMerchants) {
        this.numberOfEnemies = numberOfEnemies;
        this.numberOfMerchants = nummberOfMerchants;
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
        int dungeonRoomSize = Settings.getRoomSize();                  // TODO: Replace Settings generic object with game loop object
        int difficulty = Settings.getDifficulty();                     // TODO: ^
        int insertRandomNPC = this.rand.nextInt(3);             // 0 = Enemy, 1 = Merchant, 2 = None
        switch (insertRandomNPC) {
            case 0:
                if (this.enemiesAdded < numberOfEnemies) {
                    newRoom.addNPC(new Enemy(new Inventory(
                            new Weapon((int)Math.round((rand.nextInt(ENEMY_WEAPON_ATTACK_RANGE[1] - ENEMY_WEAPON_ATTACK_RANGE[0]) + ENEMY_WEAPON_ATTACK_RANGE[0]) * ENEMY_MULTIPLIER[difficulty]), 0),
                            new Armor((int)Math.round((rand.nextInt(ENEMY_ARMOR_ATTACK_RANGE[1] - ENEMY_ARMOR_ATTACK_RANGE[0]) + ENEMY_ARMOR_ATTACK_RANGE[0]) * ENEMY_MULTIPLIER[difficulty]), 0), 100), 100, rand.nextInt(dungeonRoomSize), rand.nextInt(dungeonRoomSize)));
                    this.enemiesAdded++;
                }
                break;
            case 1:
                if (this.merchantsAdded < this.numberOfMerchants) {
                    int randomItem = this.rand.nextInt(2);     // 0 = Armour, 1 = Weapon
                    if (randomItem == 0) {
                        newRoom.addNPC(new Merchant(rand.nextInt(dungeonRoomSize), rand.nextInt(dungeonRoomSize)));
                    } else {
                        newRoom.addNPC(new Merchant(rand.nextInt(dungeonRoomSize), rand.nextInt(dungeonRoomSize)));
                    }                                                 // TODO: Add Merchant constructor to assign item for sale (weapon/armor).
                    this.merchantsAdded++;
                }
                break;
            case 2:
                break;
        }

        return newRoom;
    }
}
