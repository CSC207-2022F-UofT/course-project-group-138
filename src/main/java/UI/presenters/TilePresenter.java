package UI.presenters;

import entities.dungeon.DungeonTile;
import settings.Settings;

import java.awt.*;

public class TilePresenter {
    private int size = Settings.getTileSize();
    private int x;
    private int y;
    public void render(DungeonTile tile, int x, int y, Graphics2D graphics2D){
        graphics2D.drawImage(tile.getImage(), x, y, size, size, null );
    }
    public void render(DungeonTile tile, Graphics2D graphics2D){
        graphics2D.drawImage(tile.getImage(), x, y, size, size, null);
    }
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
}
