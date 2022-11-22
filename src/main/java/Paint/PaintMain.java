package Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class PaintMain {
    // Declare Buttons/Button builder/Button Arrays
    JButton clearBtn, blackBtn, redBtn, blueBtn, greenBtn, eraserBtn,
            prevBtn, doneBtn, size1Btn, size2Btn, size3Btn, size4Btn;
    JButton[] buttons;
    PaintButtonBuilder buttonBuilder = new PaintButtonBuilder();
    // Declare UI
    JFrame mainFrame;
    static JLabel preview;
    PaintCanvas canvas;
    // Declare Event Handlers
    PaintEventHandler eventHandler;
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                eventHandler.handleButtonEvent(buttons, e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    };

    public static void main(String[] args) {
        new PaintMain().show();
    }

    /**
     * Presents the JFrame to screen
     */
    public void show() {
        buildButtons();
        buildLayout();

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();

        mainFrame.setSize(width, height-40);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

    }

    /**
     * Builds all the JButtons by providing neccessary information to
     * the buttonBuilder class
     */
    public void buildButtons(){
        // Build Color Buttons using buttonBuilder
        blackBtn = buttonBuilder.buildPaintBtn("black", Color.BLACK);
        redBtn = buttonBuilder.buildPaintBtn("red", Color.RED);
        blueBtn = buttonBuilder.buildPaintBtn("blue", Color.BLUE);
        greenBtn = buttonBuilder.buildPaintBtn("green", Color.GREEN);
        eraserBtn = buttonBuilder.buildPaintBtn("erase", Color.WHITE);
        // Build non-color Action Buttons using buttonBuilder
        clearBtn = buttonBuilder.buildPaintBtn("clear");
        prevBtn = buttonBuilder.buildPaintBtn("preview");
        doneBtn = buttonBuilder.buildPaintBtn("done");
        // Build size changing Buttons using buttonBuilder
        size1Btn = buttonBuilder.buildPaintBtn("1", 4);
        size2Btn = buttonBuilder.buildPaintBtn("2", 7);
        size3Btn = buttonBuilder.buildPaintBtn("3", 10);
        size4Btn = buttonBuilder.buildPaintBtn("4", 13);
    }

    /**
     * Builds the JFrame, JPanels, and sets the layout
     */
    public void buildLayout(){
        mainFrame = new JFrame("Paint");
        canvas = new PaintCanvas();
        ImageIcon bg = new ImageIcon("src/main/photos/previewbg.png");
        preview = new JLabel(bg);
        eventHandler = new PaintEventHandler(canvas, buttonBuilder.getButtonMap());
        JPanel controls = new JPanel();
        JPanel sizes = new JPanel();

        Container contents = mainFrame.getContentPane();
        contents.setBackground(Color.BLACK);
        contents.setLayout(new BorderLayout());
        contents.add(canvas, BorderLayout.CENTER);
        contents.add(controls, BorderLayout.NORTH);
        contents.add(sizes, BorderLayout.SOUTH);
        contents.add(preview, BorderLayout.EAST);
        addButtons(controls, sizes);
    }

    /**
     * Adds an ActionListener to all the JButtons, and add the buttons
     * to their respective JPanels
     * @param controls - JPanel containing all the control buttons
     * @param sizes - JPanel containing all the size buttons
     */
    public void addButtons(JPanel controls, JPanel sizes){
        JButton[] controlChoices = {clearBtn, eraserBtn, blackBtn, redBtn, blueBtn, greenBtn, prevBtn, doneBtn};
        JButton[] sizeChoices = {size1Btn, size2Btn, size3Btn, size4Btn};
        mergeBtnArrays(controlChoices, sizeChoices);
        for (JButton c : controlChoices) {
            c.addActionListener(actionListener);
            controls.add(c);
        }
        for (JButton s : sizeChoices) {
            s.addActionListener(actionListener);
            sizes.add(s);
        }
    }

    /**
     * Merges all the button arrays into one large button array named 'buttons'
     * @param a - Array 1
     * @param b - Array 2
     */
    private void mergeBtnArrays(JButton[] a, JButton[] b){
        buttons = new JButton[a.length + b.length];
        System.arraycopy(a, 0, buttons, 0, a.length);
        System.arraycopy(b, 0, buttons, a.length, b.length);
    }
}

