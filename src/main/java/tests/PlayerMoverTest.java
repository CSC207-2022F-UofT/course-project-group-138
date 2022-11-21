package tests;
import inventory.Inventory;
import org.junit.Test;
import presenters.PlayerMover;
import character.Player;
import settings.Settings;

public class PlayerMoverTest {
    private int speed;
    private Player player;
    private PlayerMover mover;
    public void initializeMover(){
        Settings.setPlayerSpeed(5);
        speed = Settings.getPlayerSpeed();
        this.player =  new Player(new Inventory(), 10, 0, 0, 0);
        this.mover = new PlayerMover(this.player);
    }

    /**
     * Tests whether x,y coords remain constant while directions set to false, and that default is set to false.
     */
    @Test
    public void testMovePlayerFalse(){
        initializeMover();
        mover.move();
        assert player.getx() == 0 : player.gety() == 0;
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
        assert player.getx() == 0 : player.gety() == 2 * speed;
    }
    @Test
    public void testMovePlayerRight(){
        initializeMover();
        mover.movingRight(true);
        mover.move();
        assert player.getx() == speed : player.gety() == 0;

    }
    @Test
    public void testMovePlayerUpDown(){
        initializeMover();
        mover.movingDown(true);
        mover.move();
        mover.movingUp(true);
        mover.movingDown(false);
        mover.move();
        assert player.getx() == 0 : player.gety() == 0;
    }
    @Test
    public void testMovePlayerDownRight(){
        initializeMover();
        mover.movingDown(true);
        mover.movingRight(true);
        mover.move();
        assert player.getx() == speed : player.gety() == speed;
    }
}
