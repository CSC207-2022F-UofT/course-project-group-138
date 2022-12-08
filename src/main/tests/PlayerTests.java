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

    /**
     * Tests getCurrentHealth()
     */
    @Test
    public void testgetCurrentHealth() {
        initializePlayer();
        assert player.getCurrentHealth() == 20;
    }

    /**
     * Tests upgradeMaximumHealth()
     */
    @Test
    public void testupgradeMaximumHealth() {
        initializePlayer();
        player.upgradeMaximumHealth(10);
        assert player.getCurrentHealth() == 30;
    }

    /**
     * Tests isAlive() returns true
     */
    @Test
    public void testisAlivetrue() {
        initializePlayer();
        assert player.isAlive();
    }

    /**
     * Tests getCoins()
     */
    @Test
    public void testgetCoins() {
        initializePlayer();
        assert player.getCoins() == 20;

    }

    /**
     * Tests spendCoins()
     */
    @Test
    public void testspendCoins() {
        initializePlayer();
        player.spendCoins(10);
        assert player.getCoins() == 20;
    }

    /**
     * Tests getAttackPower()
     */
    @Test
    public void testgetAttackPower() {
        initializePlayer();
        assert player.getAttackPower() == 10;
    }

    /**
     * Tests getArmorDurability
     */
    @Test
    public void testgetArmorDurability() {
        initializePlayer();
        assert player.getArmorDurability() == 10;
    }

    /**
     * Tests isFacing_right()
     */
    @Test
    public void testisFacing_right() {
        initializePlayer();
        assert player.isFacing_right();
    }

    /**
     * Tests setFacing_right false
     */
    @Test
    public void testsetFacing_right() {
        initializePlayer();
        player.setFacing_right(false);
        assert !player.isFacing_right();
    }

    /**
     * Tests changex() changey()
     */
    @Test
    public void testChangexy() {
        initializePlayer();
        player.changex(5);
        player.changey(-5);
        assert player.getX() == 15 : player.getY() == 5;
    }

    // I really hope these two upgrade methods don't weird out due to rounding issues or something. They should round
    // by themselves, so there shouldn't be any issues.
    /**
     * Tests upgradeArmor()
     */
    @Test
    public void testupgradeArmor() {
        initializePlayer();
        player.upgradeArmor(1.5);
        assert player.getArmorDurability() == 15;
    }

    /**
     * Tests upgradeWeapon()
     */
    @Test
    public void testupgradeWeapon() {
        initializePlayer();
        player.upgradeWeapon(1.5);
        assert player.getAttackPower() == 15;
    }

    /**
     * Tests damage() in the case that the shield breaks but saves the player from dying
     */
    @Test
    public void testdamagebreak() {
        initializePlayer();
        player.damage(25);
        assert player.getArmorDurability() == 0 : player.getCurrentHealth() == 5;
    }

    /**
     * Tests damage() in the case that the shield does not break
     */
    @Test
    public void testdamagehold() {
        initializePlayer();
        player.damage(9);
        assert player.getArmorDurability() == 4 : player.getCurrentHealth() == 17;
    }

    /**
     * Tests damage() in the case that the shield breaks and the player dies
     */
    @Test
    public void testdamagekill() {
        initializePlayer();
        player.damage(30);
        assert player.getArmorDurability() == 0 : !player.isAlive();
    }

    /**
     * Tests renewArmor()
     */
    @Test
    public void testrenewArmor() {
        initializePlayer();
        player.renewArmor(20);
        assert player.getArmorDurability() == 20;
    }


}
