package UI.presenters;

import entities.dungeon.DungeonTile;
import gateways.ImageGateway;
import gateways.MapReader;
import settings.Settings;
import useCases.AnimationStrategy;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class TilePresenter {
    private final DungeonTile[] tiles;
    private final MapReader mapReader;
    private int[][] tileMap;
    private final AnimationStrategy torchAnimator;
    private Rectangle tileRect;
    private final Set<Integer> floorTransparentTiles = new HashSet<>();
    private final Set<Integer> blackTransparentTiles = new HashSet<>();
    private final Set<Integer> wallTransparentTiles = new HashSet<>();
    private final Set<Integer> wallWTransparentTiles = new HashSet<>();
    private final Set<Integer> wallETransparentTiles = new HashSet<>();
    private final int tileSize = Settings.getTileSize();

    public TilePresenter(){
        mapReader = new MapReader();
        tiles = new DungeonTile[75];

        initializeTileArray();
        populateTileMap(0);
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


        torchAnimator = new AnimationStrategy(25, 8);
    }

    /**
     * Initialize all the tiles in the arrays and set their images.
     */
    public void initializeTileArray(){
        for (int i = 0; i < tiles.length; i++){
            tiles[i] = new DungeonTile();
        }
        tiles[0].setImage(ImageGateway.getFloorPlain());
        tiles[1].setImage(ImageGateway.getWallCenter());
        tiles[2].setImage(ImageGateway.getGrassImage());
        tiles[3].setImage(ImageGateway.getWallOuterEast());
        tiles[4].setImage(ImageGateway.getWallInnerSE());
        tiles[5].setImage(ImageGateway.getSquareTileImage());
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

    }
    public void renderTiles(Graphics2D graphics2D){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < Settings.getColumns() && row < Settings.getRows()){
            int tileNum = tileMap[col][row];
            if (tileNum == 99){
                tileNum = torchAnimator.getNextFrame();
            }
            if (tileNum == 98){
                tileNum = torchAnimator.getNextFrame() + 24;
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
    private void populateTileMap(int mapNum){
        tileMap = mapReader.loadMap(mapNum);
    }
}

