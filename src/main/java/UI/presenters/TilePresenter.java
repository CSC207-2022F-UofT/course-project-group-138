package UI.presenters;

import entities.dungeon.DungeonTile;
import gateways.ImageGateway;
import gateways.MapReader;
import settings.Settings;
import useCases.AnimationStrategy;

import java.awt.*;
import java.util.*;
import java.util.List;

public class TilePresenter {
    /**
     * This class is responsible for Presenting every tile in the game. It follows that this
     * class is respoonsible for presenting the entire map.
     */
    private final DungeonTile[] tiles;
    private final MapReader mapReader;
    // rectangular array representing the map in terms of tiles
    private int[][] tileMap;
    private final AnimationStrategy torchAnimator;
    private Rectangle tileRect;
    // Sets that contain tile codes that stack on different tiles (special tiles)
    private final Set<Integer> floorTransparentTiles = new HashSet<>();
    private final Set<Integer> blackTransparentTiles = new HashSet<>();
    private final Set<Integer> wallTransparentTiles = new HashSet<>();
    private final Set<Integer> wallWTransparentTiles = new HashSet<>();
    private final Set<Integer> wallETransparentTiles = new HashSet<>();
    private final int tileSize = Settings.getTileSize();
    private List<Integer> clipTiles;
    private List<Rectangle> collisionArray;

    /**
     * Constructs a TilePresenter object, while noting the special tiles
     */
    public TilePresenter(){
        mapReader = new MapReader();
        tiles = new DungeonTile[75];

        initializeTileArray();
        populateTileMap(0);
        addSpecialTiles();

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
            if (floorTransparentTiles.contains(tileNum)){
                graphics2D.drawImage(tiles[0].getImage(), x, y, tileSize, tileSize, null);
            } else if (blackTransparentTiles.contains(tileNum)) {
                graphics2D.drawImage(tiles[9].getImage(), x, y, tileSize, tileSize, null);
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
     * Instead, it calls the ImageGateway gateway, which returns the desired sprite.
     */
    private void initializeTileArray(){
        for (int i = 0; i < tiles.length; i++){
            tiles[i] = new DungeonTile();
        }
        clipTiles = new ArrayList<>(Arrays.asList(1, 4, 22, 19, 6, 7, 13,
                14, 40, 48, 3, 9, 46, 47, 35, 23, 24, 10,
                21, 11, 37, 38, 18, 12, 15));
        for (int i = 49; i <= 56; i++){
            clipTiles.add(i);
        }
        for (int i = 25; i <= 33; i++){
            clipTiles.add(i);
        }

        tiles[0].setImage(ImageGateway.getMud1());
        tiles[1].setImage(ImageGateway.getWallCenter());
        tiles[2].setImage(ImageGateway.getGrassImage());
        tiles[3].setImage(ImageGateway.getWallOuterEast());
        tiles[4].setImage(ImageGateway.getWallInnerSE());
        tiles[5].setImage(ImageGateway.getFloorPlain());
        tiles[6].setImage(ImageGateway.getWallInnerSW());
        tiles[7].setImage(ImageGateway.getWallOuterWest());
        tiles[8].setImage(ImageGateway.getDarknessBottom());
        tiles[9].setImage(ImageGateway.getBlack());
        tiles[10].setImage(ImageGateway.getDoorClosed());
        tiles[11].setImage(ImageGateway.getWallOuterNorth());
        tiles[12].setImage(ImageGateway.getWallFront());
        tiles[13].setImage(ImageGateway.getWallInnerE());
        tiles[14].setImage(ImageGateway.getWallInnerW());
        tiles[15].setImage(ImageGateway.getWallInnerNW());
        tiles[16].setImage(ImageGateway.getColumn());
        tiles[17].setImage(ImageGateway.getWallOuterTop());
        tiles[18].setImage(ImageGateway.getWallInnerNE());
        tiles[19].setImage(ImageGateway.getWallMissingBrick1());
        tiles[20].setImage(ImageGateway.getWallDrain());
        tiles[21].setImage(ImageGateway.getWallGratings());
        tiles[22].setImage(ImageGateway.getWallFlagRed());
        tiles[23].setImage(ImageGateway.getGargoyleRed());
        tiles[24].setImage(ImageGateway.getGargoyleGreen());
        tiles[25].setImage(ImageGateway.getTorch1());
        tiles[26].setImage(ImageGateway.getTorch2());
        tiles[27].setImage(ImageGateway.getTorch3());
        tiles[28].setImage(ImageGateway.getTorch4());
        tiles[29].setImage(ImageGateway.getTorch5());
        tiles[30].setImage(ImageGateway.getTorch6());
        tiles[31].setImage(ImageGateway.getTorch7());
        tiles[32].setImage(ImageGateway.getTorch8());
        tiles[33].setImage(ImageGateway.getDarknessLeft());
        tiles[34].setImage(ImageGateway.getDarknessLeft());
        tiles[35].setImage(ImageGateway.getDarknessLeft());
        tiles[36].setImage(ImageGateway.getDarknessRight());
        tiles[37].setImage(ImageGateway.getDarknessRight());
        tiles[38].setImage(ImageGateway.getDarknessRight());
        tiles[40].setImage(ImageGateway.getBox());
        tiles[41].setImage(ImageGateway.getBoxStacked());
        tiles[42].setImage(ImageGateway.getEdgeSingle());
        tiles[43].setImage(ImageGateway.getStairsTop());
        tiles[44].setImage(ImageGateway.getStairsMid());
        tiles[45].setImage(ImageGateway.getStairsBot());
        tiles[46].setImage(ImageGateway.getStairsMid());
        tiles[47].setImage(ImageGateway.getStairsMid());
        tiles[48].setImage(ImageGateway.getBoxLeft());
        tiles[49].setImage(ImageGateway.getTorch1());
        tiles[50].setImage(ImageGateway.getTorch2());
        tiles[51].setImage(ImageGateway.getTorch3());
        tiles[52].setImage(ImageGateway.getTorch4());
        tiles[53].setImage(ImageGateway.getTorch5());
        tiles[54].setImage(ImageGateway.getTorch6());
        tiles[55].setImage(ImageGateway.getTorch7());
        tiles[56].setImage(ImageGateway.getTorch8());
        for (int tileNum : clipTiles){
            tiles[tileNum].setClips(true);
        }
        for (DungeonTile tile : tiles){
            tile.initializeRect();
        }
    }

    /**
     * Adds the special tiles to its respective type
     */
    private void addSpecialTiles(){
        floorTransparentTiles.add(2);
        floorTransparentTiles.add(34);
        floorTransparentTiles.add(8);
        floorTransparentTiles.add(10);
        floorTransparentTiles.add(15);
        floorTransparentTiles.add(16);
        floorTransparentTiles.add(17);
        floorTransparentTiles.add(18);
        floorTransparentTiles.add(35);
        floorTransparentTiles.add(36);
        floorTransparentTiles.add(38);
        floorTransparentTiles.add(40);
        floorTransparentTiles.add(48);

        for (int i = 49; i <= 56; i++){
            floorTransparentTiles.add(i);
        }

        blackTransparentTiles.add(3);
        blackTransparentTiles.add(4);
        blackTransparentTiles.add(6);
        blackTransparentTiles.add(7);
        blackTransparentTiles.add(11);

        wallTransparentTiles.add(33);
        for (int i = 25; i <= 33; i++){
            wallTransparentTiles.add(i);
        }
        wallTransparentTiles.add(37);
    }

    /**
     * Renders the miscellaneous tile cases
     * @param graphics2D - g2d object to render onto
     * @param tileNum - miscellaneous tile in question
     * @param x - x location to render
     * @param y - y location to render
     */
    private void miscTileCases(Graphics2D graphics2D, int tileNum, int x, int y){
        if (tileNum == 35){
            graphics2D.drawImage(tiles[18].getImage(), x, y, tileSize, tileSize, null);
        }
        else if (tileNum == 38 || tileNum == 46){
            graphics2D.drawImage(tiles[15].getImage(), x, y, tileSize, tileSize, null);
        }
        else if (tileNum == 47){
            graphics2D.drawImage(tiles[18].getImage(), x, y, tileSize, tileSize, null);
        }

    }

    /**
     * Calls the load map method from the mapReader object. Gets the rectangular array.
     * @param mapNum - code corresponding with each map
     */
    private void populateTileMap(int mapNum){
        tileMap = mapReader.loadMap(mapNum);
        populateCollisionArray();
    }
    public void populateCollisionArray(){
        Set<Integer> smallTiles = new HashSet<>();
        smallTiles.add(15);
        smallTiles.add(46);
        smallTiles.add(47);
        smallTiles.add(35);
        int size = Settings.getTileSize();
        collisionArray = new ArrayList<>();
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < Settings.getColumns() && row < Settings.getRows()){
            int tileNum = tileMap[col][row];
            if (tileNum > 90){
                tileNum = 25;
            }

            if (tiles[tileNum].clips()){
                if (smallTiles.contains(tileNum)){
                    collisionArray.add(new Rectangle(x, (int) (y + Math.round(size * 0.66)), size + 5, size / 4 ));
                }
                else {
                    collisionArray.add(new Rectangle(x, y, size + 5, size));
                }
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
}

