package dungeon;

import character.Player;
import inventory.Armor;
import inventory.Inventory;
import inventory.Weapon;
import character.Merchant;

import java.util.Random;

public class DungeonRoomBuilder {
    private final int numberOfMerchants;
    private final int numberOfEnemies;
    private int merchantsAdded;
    private int enemiesAdded;
    private Random rand;

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
        int insertRandomNPC = this.rand.nextInt(3);             // 0 = Enemy, 1 = Merchant, 2 = None
        switch (insertRandomNPC) {
            case 0:
                if (this.enemiesAdded < numberOfEnemies) {
                    newRoom.addNPC(new Object(), "E");          // Replace Object() with Enemy() when merged into main
                    this.enemiesAdded++;
                }
                break;
            case 1:
                if (this.merchantsAdded < this.numberOfMerchants) {
                    int randomItem = this.rand.nextInt(2);     // 0 = Armour, 1 = Weapon
                    if (randomItem == 0) {
                        newRoom.addNPC(new Merchant(0, 0), "M");
                    } else {
                        newRoom.addNPC(new Merchant(0, 0), "M");
                    }                                                 // TODO: Assign item properties randomly?
                    this.merchantsAdded++;
                }
                break;
            case 2:
                break;
        }

        return newRoom;
    }
}
