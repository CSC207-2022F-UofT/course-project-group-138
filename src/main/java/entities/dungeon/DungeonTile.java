package entities.dungeon;

import entities.Entity;
import settings.Settings;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DungeonTile {
    /**
     * Originally, this class extended Entity, and had a ViewModel attached to it. However, that method
     * may take up too much memory and processing, since every small graphical object would
     * require a new Rectangle to be constructed.
     *
     * This would be wasteful, since most of the tiles don't require a rectangle to check collisions.
     */
    private boolean clips = false; // true if and only if it is collidable with player}
    private BufferedImage image;
    private Rectangle tileRect;
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
    public void initializeRect(){
        if (clips){
            tileRect = new Rectangle(0, 0, Settings.getTileSize(), Settings.getTileSize());
        }
    }
    public Rectangle getTileRect(){
        return tileRect;
    }
    public void setRectLocation(int x, int y){
        tileRect.x = x;
        tileRect.y = y;
    }
}
