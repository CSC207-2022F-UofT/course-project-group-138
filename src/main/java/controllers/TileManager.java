package controllers;

import UI.presenters.TilePresenter;
import entities.builders.TileArrayBuilder;
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
    private final TileArrayBuilder tileBuilder;
    private Set<Integer> floorTransparentTiles;
    private Set<Integer> blackTransparentTiles;
    private Set<Integer> wallTransparentTiles;
    private final int tileSize = Settings.getTileSize();
    private List<Rectangle> collisionArray;
    private HashMap<Integer, Enum<TileArrayBuilder.Door>> doorMap;

    /**
     * Constructs a TilePresenter object, while noting the special tiles
     */
    public TileManager(){
        mapReader = new MapReader();
        tiles = new DungeonTile[75];
        tileBuilder = new TileArrayBuilder();
        initializeTileArray();
        populateTileMap(0);
        addSpecialTiles();
        doorMap = tileBuilder.buildDoorMap();
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

        while (col < Settings.getColumns() && row < Settings.getRows()){
            int tileNum = tileMap[col][row];

            // Animate the Torch on the wall
            if (tileNum == 99){
                tileNum = torchAnimator.getNextFrame();
            }

            // Animate the Torch on the floor
            if (tileNum == 98){
                tileNum = torchAnimator.getNextFrame() + 24;
            }
            if (tiles[tileNum].clips()){
                tiles[tileNum].setRectLocation(x, y);
            }
            tilePresenter.setLocation(x, y);
            if (floorTransparentTiles.contains(tileNum)){
                tilePresenter.render(tiles[0], graphics2D);
            } else if (blackTransparentTiles.contains(tileNum)) {
                tilePresenter.render(tiles[9], graphics2D);
            } else if (wallTransparentTiles.contains(tileNum)) {
                graphics2D.drawImage(tiles[12].getImage(), x, y, tileSize, tileSize, null);
            }
            graphics2D.drawImage(tiles[tileNum].getImage(), x, y, tileSize, tileSize, null);
            miscTileCases(graphics2D, tileNum, x, y);
            // Set the tile rectangle locations

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

    /**
     * Initialize all the tiles in the arrays and set their images.
     *
     * NOTE: This method does not access assets from resources directly.
     * Instead, it calls the builder, which also calls the ImageGateway gateway, finally returning the desired sprite.
     */
    private void initializeTileArray(){
        tiles = tileBuilder.buildTileArray();
        tileBuilder.buildClipTiles();
    }

    /**
     * Adds the special tiles to its respective type
     */
    private void addSpecialTiles(){
        floorTransparentTiles = tileBuilder.buildFloorTransparentSet();
        blackTransparentTiles = tileBuilder.buildBlackTransparentSet();
        wallTransparentTiles = tileBuilder.buildWallTransparentSet();
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

    public void populateCollisionMap(){
        collisionArray = tileBuilder.buildCollisionArray(tileMap);
    }
}

