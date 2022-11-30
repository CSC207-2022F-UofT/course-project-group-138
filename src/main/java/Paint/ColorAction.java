package Paint;

import java.awt.*;

public class ColorAction implements PaintAction{
    /**
     * A class responsible for the "change color" use case
     */
    private final Color color;
    public ColorAction(Color c){
        this.color = c;
    }

    /**
     * Sets canvas paint color to color.
     * @param canvas - the paint canvas
     */
    @Override
    public void execute(PaintCanvas canvas) {
        canvas.setPaintColor(color);
    }
}
