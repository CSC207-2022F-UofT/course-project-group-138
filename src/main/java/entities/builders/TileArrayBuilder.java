package entities.builders;

import entities.dungeon.DungeonTile;
import gateways.ImageGateway;
import settings.Settings;

import java.awt.*;
import java.util.*;
import java.util.List;

public class TileArrayBuilder {
    private final DungeonTile[] tiles;
    private final Set<Integer> floorTransparentTiles = new HashSet<>();
    private final Set<Integer> blackTransparentTiles = new HashSet<>();
    private final Set<Integer> wallTransparentTiles = new HashSet<>();
    public TileArrayBuilder(){
        tiles = new DungeonTile[75];
    }

    /**
     * Initializes all the tiles and assigns them to their corresponding image using the gateway
     * @return - The array of tiles on the map
     */
    public DungeonTile[] buildTileArray(){
        // Initialize all the tiles in the array
        for (int i = 0; i < tiles.length; i++){
            tiles[i] = new DungeonTile();
        }

        // Get Images from Gateway
        // Primary floor
        tiles[0].setImage(ImageGateway.getMud1());
        // Walls
        tiles[1].setImage(ImageGateway.getWallCenter());
        tiles[2].setImage(ImageGateway.getGrassImage());
        tiles[3].setImage(ImageGateway.getWallOuterEast());
        tiles[4].setImage(ImageGateway.getWallInnerSE());
        // Secondary floor
        tiles[5].setImage(ImageGateway.getFloorPlain());
        // Inner Walls
        tiles[6].setImage(ImageGateway.getWallInnerSW());
        tiles[7].setImage(ImageGateway.getWallOuterWest());
        // Darkness and Black
        tiles[8].setImage(ImageGateway.getDarknessBottom());
        tiles[9].setImage(ImageGateway.getBlack());
        tiles[10].setImage(ImageGateway.getDoorClosed());
        // Wall outer
        tiles[11].setImage(ImageGateway.getWallOuterNorth());
        tiles[12].setImage(ImageGateway.getWallFront());
        // Small walls
        tiles[13].setImage(ImageGateway.getWallInnerE());
        tiles[14].setImage(ImageGateway.getWallInnerW());
        tiles[15].setImage(ImageGateway.getWallInnerNW());
        tiles[16].setImage(ImageGateway.getColumn());
        // also small walls
        tiles[17].setImage(ImageGateway.getWallOuterTop());
        tiles[18].setImage(ImageGateway.getWallInnerNE());
        // Special decorations and broken walls
        tiles[19].setImage(ImageGateway.getWallMissingBrick1());
        tiles[20].setImage(ImageGateway.getWallDrain());
        tiles[21].setImage(ImageGateway.getWallGratings());
        tiles[22].setImage(ImageGateway.getWallFlagRed());
        tiles[23].setImage(ImageGateway.getGargoyleRed());
        tiles[24].setImage(ImageGateway.getGargoyleGreen());
        // Torch Animation on the wall
        tiles[25].setImage(ImageGateway.getTorch1());
        tiles[26].setImage(ImageGateway.getTorch2());
        tiles[27].setImage(ImageGateway.getTorch3());
        tiles[28].setImage(ImageGateway.getTorch4());
        tiles[29].setImage(ImageGateway.getTorch5());
        tiles[30].setImage(ImageGateway.getTorch6());
        tiles[31].setImage(ImageGateway.getTorch7());
        tiles[32].setImage(ImageGateway.getTorch8());
        // Darkness tiles for entrance
        tiles[33].setImage(ImageGateway.getDarknessLeft());
        tiles[34].setImage(ImageGateway.getDarknessLeft());
        tiles[35].setImage(ImageGateway.getDarknessLeft());
        tiles[36].setImage(ImageGateway.getDarknessRight());
        tiles[37].setImage(ImageGateway.getDarknessRight());
        tiles[38].setImage(ImageGateway.getDarknessRight());
        // Box
        tiles[40].setImage(ImageGateway.getBox());
        tiles[41].setImage(ImageGateway.getBoxStacked());
        //Stairs
        tiles[42].setImage(ImageGateway.getEdgeSingle());
        tiles[43].setImage(ImageGateway.getStairsTop());
        tiles[44].setImage(ImageGateway.getStairsMid());
        tiles[45].setImage(ImageGateway.getStairsBot());
        tiles[46].setImage(ImageGateway.getStairsMid());
        tiles[47].setImage(ImageGateway.getStairsMid());
        // box on the left
        tiles[48].setImage(ImageGateway.getBoxLeft());
        // Torch animation on the ground
        tiles[49].setImage(ImageGateway.getTorch1());
        tiles[50].setImage(ImageGateway.getTorch2());
        tiles[51].setImage(ImageGateway.getTorch3());
        tiles[52].setImage(ImageGateway.getTorch4());
        tiles[53].setImage(ImageGateway.getTorch5());
        tiles[54].setImage(ImageGateway.getTorch6());
        tiles[55].setImage(ImageGateway.getTorch7());
        tiles[56].setImage(ImageGateway.getTorch8());

        // Collision with these tiles switches the Room
        tiles[57].setImage(ImageGateway.getDoorClosed());
        tiles[58].setImage(ImageGateway.getDoorClosed());
        tiles[59].setImage(ImageGateway.getDoorClosed());
        tiles[60].setImage(ImageGateway.getDoorClosed());
        tiles[61].setImage(ImageGateway.getDoorClosed());
        tiles[62].setImage(ImageGateway.getDoorClosed());
        return tiles;
    }

    /**
     * These tiles require stacking on floor
     * @return - set of all the tiles requiring stacking on floor
     */
    public Set<Integer> buildFloorTransparentSet(){
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
        return floorTransparentTiles;
    }

    /**
     * @return - Tiles that require stacking on black box
     */
    public Set<Integer> buildBlackTransparentSet(){
        blackTransparentTiles.add(3);
        blackTransparentTiles.add(4);
        blackTransparentTiles.add(6);
        blackTransparentTiles.add(7);
        blackTransparentTiles.add(11);
        return blackTransparentTiles;
    }

    /**
     * @return - Tiles that require stacking on wall
     */
    public Set<Integer> buildWallTransparentSet(){
        wallTransparentTiles.add(33);
        for (int i = 25; i <= 33; i++){
            wallTransparentTiles.add(i);
        }
        wallTransparentTiles.add(37);
        return wallTransparentTiles;
    }

    /**
     * This returns a integer list containing all the tiles that are collidable
     */
    public void buildClipTiles(){
        List<Integer> clipTiles = new ArrayList<>(Arrays.asList(1, 4, 22, 19, 6, 7, 13,
                14, 40, 48, 3, 9, 46, 47, 35, 23, 24, 10, 20,
                21, 11, 37, 38, 18, 12, 15));
        for (int i = 49; i <= 56; i++){
            clipTiles.add(i);
        }
        for (int i = 25; i <= 33; i++){
            clipTiles.add(i);
        }
        for (int tileNum : clipTiles){
            tiles[tileNum].setClips(true);
        }
        for (DungeonTile tile : tiles){
            tile.initializeRect();
        }
    }

    /**
     * Builds an array of tile locations which holds all the clip tiles.
     * @param tileMap - the array representation of the map
     * @return - Collision Array
     */
    public List<Rectangle> buildCollisionArray(int[][] tileMap){
        Set<Integer> smallTiles = new HashSet<>();
        smallTiles.add(15);
        smallTiles.add(46);
        smallTiles.add(47);
        smallTiles.add(35);
        int size = Settings.getTileSize();
        List<Rectangle> collisionArray = new ArrayList<>();
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
                    collisionArray.add(new Rectangle(x, (int) (y + Math.round(size * 0.66)), size, size / 4 ));
                }
                else {
                    collisionArray.add(new Rectangle(x, y, size, size));
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
        return collisionArray;
    }

    /**
     * Enum to note what tiles correspond to what door
     */
    public enum Door{
        TOP_LEFT,
        TOP_MID,
        TOP_RIGHT,
        LEFT,
        RIGHT,
        BOTTOM
    }

    /**
     * Creates a HashMap and notes which tile numbers corresond with which gate
     * @return - The door map
     */
    public HashMap<Integer, Enum<Door>> buildDoorMap(){
        HashMap<Integer, Enum<Door>> doorMap = new HashMap<>();
        doorMap.put(57, Door.TOP_LEFT);
        doorMap.put(58, Door.TOP_MID);
        doorMap.put(59, Door.TOP_RIGHT);
        doorMap.put(60, Door.LEFT);
        doorMap.put(61, Door.RIGHT);
        doorMap.put(62, Door.BOTTOM);
        return doorMap;
    }
}
