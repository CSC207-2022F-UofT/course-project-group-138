package controllers;

import UI.presenters.TilePresenter;
import entities.TileArrayInitializer;
import entities.dungeon.DungeonDoor;
import entities.dungeon.DungeonTile;
import gateways.MapReader;
import settings.Settings;
import useCases.AnimationStrategy;

import java.awt.*;
import java.util.*;
import java.util.List;

public class TileManager {
    /**
     * This class is responsible for Presenting every tile in the game. It follows that this
     * class is respoonsible for presenting the entire map.
     */
    private DungeonTile[] tiles;
    private final MapReader mapReader;
    // rectangular array representing the map in terms of tiles
    private int[][] tileMap;
    private final AnimationStrategy torchAnimator;
    // Sets that contain tile codes that stack on different tiles (special tiles)
    private final TilePresenter tilePresenter;
    private final TileArrayInitializer arrayInitializer;
    private Set<Integer> floorTransparentTiles;
    private Set<Integer> blackTransparentTiles;
    private Set<Integer> wallTransparentTiles;
    private DungeonDoor[] doors;
    private final int tileSize = Settings.getTileSize();
    private List<Rectangle> collisionArray;

    /**
     * Constructs a TilePresenter object, while noting the special tiles
     */
    public TileManager(){
        mapReader = new MapReader();
        tiles = new DungeonTile[75];
        arrayInitializer = new TileArrayInitializer();
        initializeTileArray();
        doors = arrayInitializer.buildDoorArray();
        populateTileMap(0);
        addSpecialTiles();
        tilePresenter = new TilePresenter();
        // Since the start frame for the torch starts at 25, and 8 frames total
        torchAnimator = new AnimationStrategy(25, 8);
    }

    /**
     * Render each tile from the tile map given.
     * @param graphics2D - the game graphics
     */
    public void renderTiles(Graphics2D graphics2D){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        // Loops through the tile map and renders each tile individually
        while (col < Settings.getColumns() && row < Settings.getRows()){
            int tileNum = tileMap[col][row];
            // Animate the Torch on the wall
            if (tileNum == 99){
                tileNum = torchAnimator.getNextFrame();
            }
            // Animate the Torch on the floor
            else if (tileNum == 98){
                tileNum = torchAnimator.getNextFrame() + 24;
            }
            else if (tileNum == 97 || tileNum == 96){
                tileNum = 0;
            }
            else if (tileNum == 95 || tileNum == 94){
                tileNum -= 60;
            }
            // In case it is a door
            if (tiles[tileNum].clips()){
                tiles[tileNum].setRectLocation(x, y);
            }
            // Sets the location for the presenter for this current iteration
            tilePresenter.setLocation(x, y);
            // Render floor directly under
            if (floorTransparentTiles.contains(tileNum)){
                tilePresenter.render(tiles[0], graphics2D);
            } // Render black tile directly under
            else if (blackTransparentTiles.contains(tileNum)) {
                tilePresenter.render(tiles[9], graphics2D);
            } // Render wall directly under
            else if (wallTransparentTiles.contains(tileNum)) {
                graphics2D.drawImage(tiles[12].getImage(), x, y, tileSize, tileSize, null);
            }
            // Draw the current tile image
            graphics2D.drawImage(tiles[tileNum].getImage(), x, y, tileSize, tileSize, null);
            miscTileCases(graphics2D, tileNum, x, y);
            // Set the tile rectangle locations
            // Updates row if column reaches end
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

    /**
     * Returns all the Dungeon tiles on the map.
     * @return- dungeons tiles on the map
     */
    public DungeonTile[] getTiles() {
        return tiles;
    }

    public Rectangle[] getCollisionArray() {
        return collisionArray.toArray(new Rectangle[0]);
    }

    public DungeonDoor[] getDoors() {
        return doors;
    }
    public void populateCollisionMap(){
        collisionArray = arrayInitializer.buildCollisionArray(tileMap);
    }
    public void changeRoom(int roomType) {
        populateTileMap(roomType);
        populateCollisionMap();
    }
    public int[] getEnemyLocation(){
        return arrayInitializer.getEnemyLocation();
    }
    public int[] getMerchantLocation(){
        return arrayInitializer.getMerchantLocation();
    }

    /**
     * Initialize all the tiles in the arrays and set their images.
     *
     * NOTE: This method does not access assets from resources directly.
     * Instead, it calls the builder, which also calls the ImageGateway gateway, finally returning the desired sprite.
     */
    private void initializeTileArray(){
        tiles = arrayInitializer.buildTileArray();
        arrayInitializer.buildClipTiles();
    }


    /**
     * Adds the special tiles to its respective type
     */
    private void addSpecialTiles(){
        floorTransparentTiles = arrayInitializer.buildFloorTransparentSet();
        blackTransparentTiles = arrayInitializer.buildBlackTransparentSet();
        wallTransparentTiles = arrayInitializer.buildWallTransparentSet();
    }

    /**
     * Renders the miscellaneous tile cases
     * @param graphics2D - g2d object to render onto
     * @param tileNum - miscellaneous tile in question
     * @param x - x location to render
     * @param y - y location to render
     */
    private void miscTileCases(Graphics2D graphics2D, int tileNum, int x, int y){
        if (tileNum == 35 || tileNum == 47){
            tilePresenter.render(tiles[18], x, y, graphics2D);
        }
        else if (tileNum == 38 || tileNum == 46) {
            tilePresenter.render(tiles[15], x, y, graphics2D);
        }
    }

    /**
     * Calls the load map method from the mapReader object. Gets the rectangular array.
     * @param mapNum - code corresponding with each map
     */
    private void populateTileMap(int mapNum){
        tileMap = mapReader.loadMap(mapNum);
        populateCollisionMap();
    }

}

