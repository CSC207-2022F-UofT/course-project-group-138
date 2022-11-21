package tests;
import inventory.Inventory;
import org.junit.Test;
import static org.junit.Assert.*;
import presenters.PlayerMover;
import character.Player;

public class PlayerMoverTest {
    @Test
    public void testMovePlayer(){
        Player player = new Player(new Inventory(), 10, 0, 0, 0);
        PlayerMover mover = new PlayerMover(player);
    }
}
