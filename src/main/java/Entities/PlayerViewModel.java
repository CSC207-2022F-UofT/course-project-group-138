package Entities;

import java.awt.*;

public class PlayerViewModel extends Rectangle {
    private boolean up, down, left, right;

    private int speed;

    public PlayerViewModel(int xPos, int yPos){
        super(xPos * Settings.getPlayerSize(), yPos * Settings.getPlayerSize(),
                Settings.getPlayerSize(), Settings.getPlayerSize());
        this.up = false;
        this.down = false;
        this.left = false;
        this.right = false;
        this.speed = Settings.getPlayerSpeed();
    }

    public void move() {
        if (up) {
            super.y -= this.speed;
        }
        if (down) {
            super.y += this.speed;
        }
        if (left) {
            super.x -= this.speed;
        }
        if (right) {
            super.x += this.speed;
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
