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
    JLabel sizeLabel, controlsLabel, previewLabel, canvasLabel;
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
        // Canvas and main JFrame
        mainFrame = new JFrame("Paint");
        canvas = new PaintCanvas();
        // Labels
        sizeLabel = new JLabel("Sizes: ");
        sizeLabel.setFont(new Font("Courier", Font.BOLD, 20));
        controlsLabel = new JLabel("Controls: ");
        controlsLabel.setFont(new Font("Courier", Font.BOLD, 20));
        canvasLabel = new JLabel("Canvas");
        canvasLabel.setFont(new Font("Courier", Font.BOLD, 20));
        previewLabel = new JLabel("Preview");
        previewLabel.setFont(new Font("Courier", Font.BOLD, 20));
        // Preview window
        ImageIcon bg = new ImageIcon("src/main/res/previewbg.png");
        preview = new JLabel(bg);
        // Buttons
        eventHandler = new PaintEventHandler(canvas, buttonBuilder.getButtonMap());
        JPanel controls = new JPanel();
        JPanel sizes = new JPanel();
        JPanel saving = new JPanel();
        // Filler panel
        JPanel filler = new JPanel();

        Container contents = mainFrame.getContentPane();
//        contents.setBackground(Color.BLACK);
        filler.setPreferredSize(new Dimension(100, 10));
        contents.setLayout(new GridBagLayout());

        // Adding first row of components
        Insets insets = new Insets(0, 0, 0,0);
        addComponent(contents, sizeLabel, 0, 0, 1, 1, 0.5, 0.5,
                GridBagConstraints.LINE_END, GridBagConstraints.NONE, insets);
        addComponent(contents, sizes, 1, 0, 1, 1, 0.5, 0.5,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE, insets);
        addComponent(contents, controlsLabel, 2, 0, 1, 1,  0.5, 0.5,
                GridBagConstraints.LINE_END, GridBagConstraints.NONE, insets);
        addComponent(contents, controls, 3, 0, 1, 1,  0.5, 0.5,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE, insets);

        // Adding second row of components
        addComponent(contents, canvasLabel, 2, 1, 1, 1,  0.1, 0.1,
                GridBagConstraints.PAGE_END, GridBagConstraints.NONE, insets);
        addComponent(contents, filler, 2, 1, 1, 1,  0.1, 0.1,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, insets);

        // Adding third row of components
        addComponent(contents, previewLabel, 4, 2, 1, 1,  1, 1,
                GridBagConstraints.PAGE_END, GridBagConstraints.NONE, insets);
        insets = new Insets(10, 50, 0, 0);
        addComponent(contents, canvas, 0, 2, 4, 2,  1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets);

        // Adding fourth row of components
        insets = new Insets(10, 10, 0, 10);
        addComponent(contents, preview, 4, 3, 1, 1,   1, 1,
                GridBagConstraints.PAGE_START, GridBagConstraints.NONE, insets);

        // Adding fifth row of components
        insets = new Insets(0, 0, 0,0);
        addComponent(contents, saving, 4, 4, 1, 1,   1, 1,
                GridBagConstraints.PAGE_START, GridBagConstraints.NONE, insets);

        addButtons(controls, sizes, saving);
    }

    /**
     * Adds an ActionListener to all the JButtons, and add the buttons
     * to their respective JPanels
     * @param controls - JPanel containing all the control buttons
     * @param sizes - JPanel containing all the size buttons
     */
    public void addButtons(JPanel controls, JPanel sizes, JPanel saving){
        JButton[] controlChoices = {clearBtn, eraserBtn, blackBtn, redBtn, blueBtn, greenBtn};
        JButton[] sizeChoices = {size1Btn, size2Btn, size3Btn, size4Btn};
        JButton[] savingChoices = {prevBtn, doneBtn};
        mergeBtnArrays(controlChoices, sizeChoices, savingChoices);
        for (JButton c : controlChoices) {
            c.addActionListener(actionListener);
            controls.add(c);
        }
        for (JButton s : sizeChoices) {
            s.addActionListener(actionListener);
            sizes.add(s);
        }
        for (JButton p : savingChoices) {
            p.addActionListener(actionListener);
            saving.add(p);
        }
    }

    /**
     * Merges all the button arrays into one large button array named 'buttons'
     * @param a - Array 1
     * @param b - Array 2
     */
    private void mergeBtnArrays(JButton[] a, JButton[] b, JButton[] c){
        buttons = new JButton[a.length + b.length + c.length];
        System.arraycopy(a, 0, buttons, 0, a.length);
        System.arraycopy(b, 0, buttons, a.length, b.length);
        System.arraycopy(c, 0, buttons, a.length + b.length, c.length);
    }
    private static void addComponent(Container container, Component component, int gridx, int gridy,
                                     int gridwidth, int gridheight, double weightx, double weighty, int anchor,
                                     int fill, Insets insets) {
        GridBagConstraints c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty,
                anchor, fill, insets, 0, 0);
        container.add(component, c);
    }
}

