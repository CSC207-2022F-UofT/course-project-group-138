package Paint;

import javax.swing.*;
import java.awt.event.ActionEvent;
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
    public void handleButtonEvent(JButton[] buttons, ActionEvent e){
        for (JButton p : buttons){
            if (p == e.getSource()){
                PaintAction act = buttonMap.get(p);
                act.execute(canvas);
            }
        }
    }
}
