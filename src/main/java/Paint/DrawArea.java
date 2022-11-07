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


public class DrawArea extends JComponent{
    // canvas
    private Image image;
    private Graphics2D g2;
    private Color lastColor = Color.black;

    // mouse coord
    private int currentX, currentY, oldX, oldY;

    public DrawArea(){
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
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_OFF);
            size1();
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear(){
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(lastColor);
        repaint();
    }

    public void red(){
        g2.setPaint(Color.red);
        lastColor = Color.red;
    }
    public void black() {
        g2.setPaint(Color.black);
        lastColor = Color.black;
    }
    public void blue(){
        g2.setPaint(Color.blue);
        lastColor = Color.blue;
    }
    public void green(){
        g2.setPaint(Color.green);
        lastColor = Color.green;
    }
    public void eraser() {g2.setPaint(Color.white);}
    public void size1(){
        g2.setStroke(new BasicStroke(4));
    }
    public void size2(){
        g2.setStroke(new BasicStroke(7));
    }
    public void size3(){
        g2.setStroke(new BasicStroke(10));
    }
    public void size4(){
        g2.setStroke(new BasicStroke(13));
    }

    public void done() {
        Image transparentImage = makeColorTransparent(imageToBufferedImage(image), Color.white);
        try {
            File outputFile = new File("src/main/photos/characters.png");
            outputFile.createNewFile();
            ImageIO.write(imageToBufferedImage(transparentImage), "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Image makeColorTransparent(final BufferedImage im, final Color color) {
        final ImageFilter filter = new RGBImageFilter() {
            // the color we are looking for (white)... Alpha bits are set to opaque
            public int markerRGB = color.getRGB() | 0xFFFFFFFF;

            public int filterRGB(final int x, final int y, final int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                } else {
                    // nothing to do
                    return rgb;
                }
            }
        };
        final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
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
