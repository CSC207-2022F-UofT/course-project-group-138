import entities.character.Enemy;
import entities.inventory.Armor;
import entities.inventory.Inventory;
import entities.inventory.Weapon;
import org.junit.Test;

public class EnemyTests {

    private static Enemy enemy;

    public void initializeEnemy() {
        enemy = new Enemy(new Inventory(20, new Weapon(10), new Armor(10)), 20, 10, 10);
    }

    /**
     * Tests setImageID() and getImageID().
     */
    @Test
    public void testImageID(){
        initializeEnemy();
        enemy.setImageID(10);
        assert enemy.getImageID() == 10;
    }

}
