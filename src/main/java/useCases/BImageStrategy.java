package useCases;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BImageStrategy {
    /**
     * Several methods require a BufferedImage to be passed into its parameters, while we only have Image.
     * This is one strategy in converting image to buffered image.
     */
    /**
     * @param image - to image to convert
     * @return
     */
    public static BufferedImage toBufferedImage(Image image){
        // Algo Source:
        // https://stackoverflow.com/questions/13605248/java-converting-image-to-bufferedimage
        // Checks if this image is already a bufferd image
        if (image instanceof BufferedImage){
            return (BufferedImage) image;
        }
        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(image, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
}
