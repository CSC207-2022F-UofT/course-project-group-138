package useCases.playerUseCases;
import entities.character.Player;
import settings.Settings;

// Responsible for updating the player's x, y coordinates. (This is a use case)
public class PlayerMover {
    /**
     * PlayerMover use case: Call this to move the player without altering any entities directly
     */
    private boolean up, down, left, right;
    private final int speed = Settings.getPlayerSpeed();
    private final Player player;
    private int width;
    private int height;

    /**
     * ==== Constructor ====
     * Initialize all movement to false
     * @param player - The player to move
     */
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
        if (up && player.getY() > 0) {
            player.changey(-speed);
        }
        if (down && player.getY() < Settings.canvasHeight() - Settings.getPlayerSize()) {
            player.changey(speed);
        }
        if (left && player.getX() > 0) {
            player.changex(-speed);
            player.setFacing_right(false);
        }
        if (right && player.getX() < Settings.canvasWidth() - Settings.getPlayerSize()) {
            player.changex(speed);
            player.setFacing_right(true);
        }
    }

    /**
     * ===== Setters =====
     * @param x - new x location
     */
    public void setPlayerX(int x){
        player.setX(x);
    }

    /**
     *
     * @param y - new y location
     */
    public void  setPlayerY(int y){
        player.setY(y);
    }
    // true should be passed into methods below iff player if holding down the corresponding movement key
    // Method calls below should result from a call stack originating from <engine>

    /**
     * Sets player to move up
     * @param up - true iff player is holding down up direction key
     */
    public void movingUp (boolean up){
        this.up = up;
    }

    /**
     * Sets player to move donw
     * @param down - true iff player is holding down the down direction key
     */
    public void movingDown (boolean down){
        this.down = down;
    }

    /**
     * sets player to move left
     * @param left - true iff player is holding down left direction key
     */
    public void movingLeft (boolean left){
        this.left = left;
    }

    /**
     * Sets player to move right
     * @param right - true iff player is holding down right direction key
     */
    public void movingRight (boolean right){
        this.right = right;
    }
    public int getX(){
        return player.getX();
    }
    public int getY(){
        return player.getY();
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
        player.setX(100);
        player.setY(Settings.canvasHeight() / 2 - 25);
    }
}
