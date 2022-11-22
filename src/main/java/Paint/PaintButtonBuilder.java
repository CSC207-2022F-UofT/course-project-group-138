package Paint;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PaintButtonBuilder {
    private final HashMap<JButton, PaintAction> buttonMap = new HashMap<>();

    /**
     * Takes in a Color representing the corresponding color of
     * this ColorButton. Saves this color/button combination in
     * buttonMap, and returns the constructed JButton.
     *
     * @param c - The color associated with this button
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
     * @param name - the name and action of this button
     * @return actionBtn
     */
    public JButton buildPaintBtn(String name){
        JButton actionBtn = new JButton(name);
        buttonMap.put(actionBtn, new GeneralAction(name));
        return actionBtn;
    }

    /**
     *
     * @param name - name of this button
     * @param size - the size corresponding with the stroke length
     * @return A JButton that has the size 'size'
     */
    public JButton buildPaintBtn(String name, int size){
        JButton sizeBtn = new JButton(name);
        buttonMap.put(sizeBtn, new SizeAction(size));
        return sizeBtn;
    }

    public HashMap<JButton, PaintAction> getButtonMap() {
        return buttonMap;
    }
}
