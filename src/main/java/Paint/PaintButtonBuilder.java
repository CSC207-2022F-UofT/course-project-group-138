package Paint;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PaintButtonBuilder {
    private HashMap buttonMap = new HashMap<JButton, PaintAction>();

    /**
     * Takes in a Color representing the corresponding color of
     * this ColorButton. Saves this color/button combination in
     * buttonMap, and returns the constructed JButton.
     *
     * @param c
     * @return colorBtn
     */
    public JButton buildPaintBtn(String name, Color c){
        JButton colorBtn = new JButton(name);
        buttonMap.put(colorBtn, new ColorAction(c));
        return colorBtn;
    }

    /**
     * Takes in a String representing the corresponding action of
     * this ActionButton. Saves this action/button combination in
     * buttonMap, and returns the constructed JButton.
     *
     * @param name
     * @return actionBtn
     */
    public JButton buildPaintBtn(String name){
        JButton actionBtn = new JButton(name);
        buttonMap.put(actionBtn, new GeneralAction(name));
        return actionBtn;
    }
    public JButton buildPaintBtn(String name, int size){
        JButton sizeBtn = new JButton(name);
        buttonMap.put(sizeBtn, new SizeAction(size));
        return sizeBtn;
    }

    public HashMap getButtonMap() {
        return buttonMap;
    }
}
