package useCases.playerUseCases;
import entities.character.Player;
import settings.Settings;

// Responsible for updating the player's x, y coordinates. (This is a use case)
public class PlayerMover {
    private boolean up, down, left, right;
    private final int speed = Settings.getPlayerSpeed();
    private final Player player;

    public PlayerMover(Player player){
        this.player = player;
        up = false;
        down = false;
        left = false;
        right = false;
    }

    /**
     * Update the player's x, y values if user is holding the movement direction is set to true.
     */
    public void move() {
        if (up) {
            player.changey(-speed);
        }
        if (down) {
            player.changey(speed);
        }
        if (left) {
            player.changex(-speed);
        }
        if (right) {
            player.changex(speed);
        }
    }
    // true should be passed into methods below iff player if holding down the corresponding movement key
    // Method calls below should result from a call stack originating from <engine>
    public void movingUp (boolean up){
        this.up = up;
    }
    public void movingDown (boolean down){
        this.down = down;
    }
    public void movingLeft (boolean left){
        this.left = left;
    }
    public void movingRight (boolean right){
        this.right = right;
    }
}
