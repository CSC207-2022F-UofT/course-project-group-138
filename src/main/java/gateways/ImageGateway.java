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
        try{
            // Convert to buffered image first
            return BImageStrategy.toBufferedImage(ImageIO.read(new File("src/main/res/characters.png")));
        } catch (IOException e){
            System.out.println("Trouble getting image from characters.png");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads and returns the stone tile image from its specified file location
     * @return - A regular stone tile image
     */
    public static BufferedImage getStoneTileImage(){
        try{
            // Convert to Buffered Image first
            return BImageStrategy.toBufferedImage(ImageIO.read(new File("src/main/res/tiles/stone_tile.png")));
        } catch (IOException e){
            System.out.println("Trouble getting image from characters.png");
            e.printStackTrace();
            return null;
        }
    }
}
