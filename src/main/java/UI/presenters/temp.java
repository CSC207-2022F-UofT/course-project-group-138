package UI.presenters;

import Paint.PaintCanvas;
import useCases.BImageStrategy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class temp {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/res/tiles/broke_left_tile.png");
        Image img = PaintCanvas.makeColorTransparent(BImageStrategy.toBufferedImage(ImageIO.read(file)), Color.white);
        ImageIO.write(BImageStrategy.toBufferedImage(img), "png", file);
    }
}
