package Paint;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class PaintCanvas extends JComponent{
    // canvas
    private Image image;
    private Graphics2D g2;
    private Color lastColor = Color.black;

    // mouse coord
    private int currentX, currentY, oldX, oldY;

    public PaintCanvas(){
        setDoubleBuffered(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // save coords when mouse pressed
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        // draw line
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();

                if (g2 != null) {
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        if (image == null){
            image = createImage(getSize().height, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_OFF);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }
    public void setPaintColor(Color color){
        g2.setPaint(color);
        lastColor = color;
    }
    public void setStrokeSize(int size){
        g2.setStroke(new BasicStroke(size));
    }
    public void clear(){
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(lastColor);
        repaint();
    }

    public void done() {
        Image transparentImage = makeColorTransparent(imageToBufferedImage(image), Color.white);
        try {
            File outputFile = new File("src/main/res/characters.png");
            outputFile.createNewFile();
            ImageIO.write(imageToBufferedImage(transparentImage), "png", outputFile);
            PaintMain.quit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void preview() throws IOException {
        Image transparentImage = makeColorTransparent(imageToBufferedImage(image), Color.white);
        BufferedImage previewImage = resizeImage(imageToBufferedImage(transparentImage), 500, 500);
        ImageIcon previewImageIcon = new ImageIcon(previewImage);
        PaintMain.preview.setIcon(previewImageIcon);
    }

    /**
     * Removes all the pixels of specified RGB value from the background. Keeps only coloured pixels.
     * @param image - The image to make transparent
     * @param color - must implement
     * @return - Image with transparent BG
     */
    public static Image makeColorTransparent(final BufferedImage image, final Color color) {
        final ImageFilter filter = new RGBImageFilter() {
            // CHANGE BELOW TO CHANGE BACKGROUND COLOUR
            public final int markerRGB = 0xFFFFFFFF; // This will be the BG colour the remove (RGB value)

            public int filterRGB(final int x, final int y, final int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                } else {
                    // Since this is not markerRGB, just return the color
                    return rgb;
                }
            }
        };
        final ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }

    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    private static BufferedImage imageToBufferedImage(final Image image)
    {
        final BufferedImage bufferedImage =
                new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return bufferedImage;
    }

}
