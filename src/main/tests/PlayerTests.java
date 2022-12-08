import entities.character.Enemy;
import entities.character.Player;
import entities.inventory.Armor;
import entities.inventory.Inventory;
import entities.inventory.Weapon;
import org.junit.Test;


public class PlayerTests {

    private static Player player;

    public void initializePlayer() {
        player = new Player(new Inventory(20, new Weapon(10), new Armor(10)), 20, 10, 10);
    }

    /**
     * Tests overloaded constructor without a <kills> parameter
     */
    @Test
    public void testConstructor(){
        initializePlayer();
        assert player.getKills() == 0;
    }

    /**
     * Tests getKills() and increaseKills()
     */
    @Test
    public void testKills(){
        player.increaseKills();
        player.increaseKills();
        player.increaseKills();
        assert player.getKills() == 3;
    }

}
