package Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class PaintEventHandler {
    private HashMap buttonMap;
    private HashMap<String, Color> colorMap = new HashMap();
    String action;
    PaintCanvas canvas;

    /**
     * Constructs a new PaintEventHandler object
     * @param drawArea
     */
    public PaintEventHandler(PaintCanvas drawArea, HashMap buttonMap){
        this.canvas = drawArea;
        this.buttonMap = buttonMap;
        createColorMap();
    }
    public void handleButtonEvent(JButton[] buttons, ActionEvent e){
        for (JButton p : buttons){
            if (p == e.getSource()){
                PaintAction act = (PaintAction) buttonMap.get(p);
                act.execute(canvas);
            }
        }
    }
    private void createColorMap(){
        colorMap.put("black", Color.black);
        colorMap.put("white", Color.white);
        colorMap.put("red", Color.red);
        colorMap.put("blue", Color.blue);
        colorMap.put("green", Color.green);
        colorMap.put("yellow", Color.yellow);
        colorMap.put("eraser", Color.white);
    }
}
