package presenters;
import character.Player;

public class PlayerMover {
    private boolean up, down, left, right;
    private final int speed = Settings.getPlayerSpeed();
    private Player player;

    public PlayerMover(Player player){
        this.player = player;
        up = false;
        down = false;
        left = false;
        right = false;
    }
    public void move() {
        if (up) {

        }
        if (down) {

        }
        if (left) {

        }
        if (right) {

        }
    }
    public void setUp (boolean up){
        this.up = up;
    }
    public void setDown (boolean down){
        this.down = down;
    }
    public void setLeft (boolean left){
        this.left = left;
    }
    public void setRight (boolean right){
        this.right = right;
    }
}
