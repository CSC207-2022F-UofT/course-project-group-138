package entities.builders;

import entities.dungeon.DungeonTile;
import gateways.ImageGateway;
import org.w3c.dom.css.Rect;
import settings.Settings;

import java.awt.*;
import java.util.*;
import java.util.List;

public class TileArrayBuilder {
    private DungeonTile[] tiles;
    private List<Integer> clipTiles;
    private List<Rectangle> collisionArray;
    private Set<Integer> floorTransparentTiles = new HashSet<>();
    private Set<Integer> blackTransparentTiles = new HashSet<>();
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
        return tiles;
    }
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
    public Set<Integer> buildBlackTransparentSet(){
        blackTransparentTiles.add(3);
        blackTransparentTiles.add(4);
        blackTransparentTiles.add(6);
        blackTransparentTiles.add(7);
        blackTransparentTiles.add(11);
        return blackTransparentTiles;
    }
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
     * @return - Collidable array
     */
    public List<Integer> buildClipArray(){
        clipTiles = new ArrayList<>(Arrays.asList(1, 4, 22, 19, 6, 7, 13,
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
        return clipTiles;
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
}
