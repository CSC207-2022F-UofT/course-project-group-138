package Game;

import character.Player;
import dungeon.Dungeon;
import inventory.Inventory;
import presenters.PlayerMover;
import settings.Settings;

import java.awt.event.KeyEvent;

public class MainPlayingState extends State{
    Player player;
    PlayerMover playerMover;
    Dungeon dungeon;

    public MainPlayingState(){
        super();
        this.player = new Player(new Inventory(), Settings.getMaxHp(), 0, 0);
        // #TODO Review dungeon instatiation
        // Initialize Dungeon with difficulty 0
        this.dungeon = new Dungeon(0);
        this.playerMover = new PlayerMover(player);
    }
    @Override
    protected void loop() {
        playerMover.move();
    }

    @Override
    protected void render() {

    }

    @Override
    protected void keyPressed(int code) {
        updatePlayerMover(code, true);
    }

    @Override
    protected void keyReleased(int code) {
        updatePlayerMover(code, false);
    }
    private void updatePlayerMover(int code, boolean bool){
        switch(code) {
            case KeyEvent.VK_W:
                this.playerMover.movingUp(bool);
                break;
            case KeyEvent.VK_A:
                this.playerMover.movingLeft(bool);
                break;
            case KeyEvent.VK_S:
                this.playerMover.movingDown(bool);
                break;
            case KeyEvent.VK_D:
                this.playerMover.movingRight(bool);
                break;
        }
    }
}
