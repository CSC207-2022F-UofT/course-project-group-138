import entities.inventory.Armor;
import entities.inventory.Inventory;
import entities.inventory.Weapon;
import org.junit.Test;
import useCases.playerUseCases.PlayerMover;
import entities.character.Player;
import settings.Settings;

public class PlayerMoverTest {
    private int speed;
    private Player player;
    private PlayerMover mover;
    public void initializeMover(){
        Settings.setPlayerSpeed(5);
        speed = Settings.getPlayerSpeed();
        this.player =  new Player(new Inventory(1, new Weapon(1), new Armor(1)), 10, 0, 0, 0);
        this.mover = new PlayerMover(this.player);
    }

    /**
     * Tests whether x,y coords remain constant while directions set to false, and that default is set to false.
     */
    @Test
    public void testMovePlayerFalse(){
        initializeMover();
        mover.move();
        assert player.getX() == 0 : player.getY() == 0;
    }

    /**
     * Tests whether player has moved down twice during two "move" calls while "down" is set to true.
     *
     * Tests whether player has remained still while "move" method is not called.
     */
    @Test
    public void testMovePlayerDown(){
        initializeMover();
        mover.movingDown(true);
        mover.move();
        mover.move();
        mover.movingDown(false);
        mover.move();
        mover.movingRight(true);
        assert player.getX() == 0 : player.getY() == 2 * speed;
    }
    @Test
    public void testMovePlayerRight(){
        initializeMover();
        mover.movingRight(true);
        mover.move();
        assert player.getX() == speed : player.getY() == 0;

    }
    @Test
    public void testMovePlayerUpDown(){
        initializeMover();
        mover.movingDown(true);
        mover.move();
        mover.movingUp(true);
        mover.movingDown(false);
        mover.move();
        assert player.getX() == 0 : player.getY() == 0;
    }
    @Test
    public void testMovePlayerDownRight(){
        initializeMover();
        mover.movingDown(true);
        mover.movingRight(true);
        mover.move();
        assert player.getX() == speed : player.getY() == speed;
    }
}
