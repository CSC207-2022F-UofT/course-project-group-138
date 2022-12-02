package Paint;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.HashMap;

public class PaintEventHandler {
    private final HashMap<JButton, PaintAction> buttonMap;
    PaintCanvas canvas;

    /**
     * Constructs a new PaintEventHandler object
     * @param canvas - the canvas of the paint program
     * @param buttonMap - a Hashmap that maps each button to an action
     */
    public PaintEventHandler(PaintCanvas canvas, HashMap<JButton, PaintAction> buttonMap){
        this.canvas = canvas;
        this.buttonMap = buttonMap;
    }

    /**
     * Takes advantage of polymorphism to determine which button was pressed, and execute the action accordingly.
     * Implementation of each action will reside in each instance of PaintAction
     * @param buttons - An array of available JButtons
     * @param e - The action event corresponding to one of these buttons
     * @throws IOException - May throw exception when saving to file
     */
    public void handleButtonEvent(JButton[] buttons, ActionEvent e) throws IOException {
        for (JButton p : buttons){
            if (p == e.getSource()){
                PaintAction act = buttonMap.get(p);
                act.execute(canvas);
            }
        }
    }
}
