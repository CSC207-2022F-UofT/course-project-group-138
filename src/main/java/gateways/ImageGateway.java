package gateways;

import useCases.BImageStrategy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageGateway {
    /**
     * Reads and returns the player image from its specified file location
     * @return - the player image
     */
    public static BufferedImage getPlayerImage(){
        return getImage("src/main/res/characters.png");
    }

    /**
     * Reads and returns the stone tile image from its specified file location
     * @return - A regular stone tile image
     */
    public static BufferedImage getStoneTileImage(){
        return getImage("src/main/res/tiles/stone_tile.png");
    }
    public static BufferedImage getPinkFloorTileImage(){
        return getImage("src/main/res/tiles/pink_floor_tile.jpg");
    }
    public static BufferedImage getBrownWallTileImage(){
        return getImage("src/main/res/tiles/brown_wall_tile.png");
    }
    public static BufferedImage getBrickWallTileImage() {
        return getImage("src/main/res/tiles/brick_wall_tile.png");
    }
    public static BufferedImage getSquareTileImage(){
        return getImage("src/main/res/tiles/square_tile.png");
    }

    private static BufferedImage getImage(String fileName){
        try{
            // Convert to Buffered Image first
            return BImageStrategy.toBufferedImage(ImageIO.read(new File(fileName)));
        } catch (IOException e){
            System.out.println("Trouble getting image from characters.png");
            e.printStackTrace();
            return null;
        }
    }
}
