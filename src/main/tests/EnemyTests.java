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
     * Tests whether x,y coords remain constant while directions set to false, and that default is set to false.
     */
    @Test
    public void testMovePlayerFalse(){
        initializeEnemy();
        assert enemy.getX() == 0 : enemy.getY() == 0;
    }

}
