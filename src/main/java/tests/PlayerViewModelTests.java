package tests;

import character.Player;
import inventory.Inventory;
import org.junit.Test;
import presenters.PlayerMover;
import presenters.PlayerViewModel;
import settings.Settings;

public class PlayerViewModelTests {
    private int speed;
    private Player player;
    private PlayerMover mover;
    private PlayerViewModel viewModel;
    public void initializeViewModel() {
        Settings.setPlayerSpeed(5);
        Settings.setPlayerSize(3);
        speed = Settings.getPlayerSpeed();
        this.player =  new Player(new Inventory(), 10, 0, 0, 0);
        this.mover = new PlayerMover(this.player);
        this.viewModel = new PlayerViewModel(player);
    }
    @Test
    public void testPlayerViewModelPosition(){
        initializeViewModel();
        this.mover.movingDown(true);
        this.mover.movingRight(true);
        this.mover.move();
        viewModel.updatePosition();
        assert viewModel.getX() == speed : viewModel.getY() == speed;
    }
}
