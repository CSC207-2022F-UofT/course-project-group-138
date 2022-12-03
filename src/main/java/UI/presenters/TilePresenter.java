package UI.presenters;

import entities.dungeon.DungeonTile;
import gateways.ImageGateway;
import gateways.MapReader;
import settings.Settings;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TilePresenter {
    private DungeonTile[] tiles;
    private MapReader mapReader;
    private int[][] tileMap;
    private Rectangle tileRect;

    public TilePresenter(){
        mapReader = new MapReader();
        tiles = new DungeonTile[10];
        initializeTileArray();
        populateTileMap(0);
    }
    public void initializeTileArray(){
        for (int i = 0; i < tiles.length; i++){
            tiles[i] = new DungeonTile();
        }
        tiles[0].setImage(ImageGateway.getGround3());
        tiles[1].setImage(ImageGateway.getPinkFloorTileImage());
        tiles[2].setImage(ImageGateway.getGrassImage());
        tiles[3].setImage(ImageGateway.getBrownWallTileImage());
        tiles[4].setImage(ImageGateway.getStoneTileImage());
        tiles[5].setImage(ImageGateway.getSquareTileImage());
        tiles[6].setImage(ImageGateway.getBrokeRightTileImage());
        tiles[7].setImage(ImageGateway.getBrokeLeftTileImage());
    }
    public void renderTiles(Graphics2D graphics2D){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < Settings.getColumns() && row < Settings.getRows()){
            int tileNum = tileMap[col][row];
            if (tileNum == 2 || tileNum == 6 || tileNum == 7){
                graphics2D.drawImage(tiles[0].getImage(), x, y, Settings.getTileSize(), Settings.getTileSize(), null);
            }
            graphics2D.drawImage(tiles[tileNum].getImage(), x, y, Settings.getTileSize(), Settings.getTileSize(), null);
            if (tileNum == 9){
                graphics2D.setColor(Color.BLACK);
                graphics2D.fillRect(x, y, Settings.getTileSize(), Settings.getTileSize());
            }
            col++;
            x += Settings.getTileSize();
            if (col == Settings.getColumns()){
                col = 0;
                x = 0;
                row++;
                y += Settings.getTileSize();
            }
        }
    }
    private void populateTileMap(int mapNum){
        tileMap = mapReader.loadMap(mapNum);
    }
}
