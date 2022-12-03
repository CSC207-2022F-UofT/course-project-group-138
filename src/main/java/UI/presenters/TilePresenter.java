package UI.presenters;

import entities.dungeon.DungeonTile;
import gateways.ImageGateway;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TilePresenter {
    private DungeonTile[] tiles;
    private Rectangle tileRect;

    public TilePresenter(){
        tiles = new DungeonTile[5];
    }
    public void initializeTileArray(){
        tiles[0] = new DungeonTile();
        tiles[0].setImage(ImageGateway.getStoneTileImage());
    }
    public void renderTile(Graphics2D graphics2D){

    }
}
