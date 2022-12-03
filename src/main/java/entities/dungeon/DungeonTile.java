package entities.dungeon;

import entities.Entity;

import java.awt.image.BufferedImage;

public class DungeonTile {
    private boolean clips = false; // true if and only if it is collidable with player}
    private BufferedImage image;
    public BufferedImage getImage(){
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setClips(boolean clips){
        this.clips = clips;
    }
    public boolean clips(){
        return clips;
    }
}
