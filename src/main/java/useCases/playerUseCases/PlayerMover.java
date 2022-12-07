package useCases.playerUseCases;
import entities.character.Player;
import settings.Settings;

// Responsible for updating the player's x, y coordinates. (This is a use case)
public class PlayerMover {
    private boolean up, down, left, right;
    private final int speed = Settings.getPlayerSpeed();
    private final Player player;
    private int width;
    private int height;

    public PlayerMover(Player player){
        this.player = player;
        up = false;
        down = false;
        left = false;
        right = false;
    }

    /**
     * Update the player's x, y values if user is holding the movement direction is set to true.
     * Checks whether player is hitting the edge of the frame.
     */
    public void move() {
        if (up && player.gety() > 0) {
            player.changey(-speed);
        }
        if (down && player.gety() < Settings.canvasHeight() - Settings.getPlayerSize()) {
            player.changey(speed);
        }
        if (left && player.getx() > 0) {
            player.changex(-speed);
            player.setFacing_right(false);
        }
        if (right && player.getx() < Settings.canvasWidth() - Settings.getPlayerSize()) {
            player.changex(speed);
            player.setFacing_right(true);
        }
    }
    public void setPlayerX(int x){
        player.setX(x);
    }
    public void  setPlayerY(int y){
        player.setY(y);
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
    public int getX(){
        return player.getx();
    }
    public int getY(){
        return player.gety();
    }
    public boolean isUp(){
        return  this.up;
    }
    public boolean isRight() {
        return right;
    }
    public boolean isLeft() {
        return left;
    }
    public boolean isDown() {
        return down;
    }

    public void newRoom() {
        player.setX(Settings.canvasWidth() / 2);
        player.setY(Settings.canvasHeight() * 3 / 4);
    }
}
