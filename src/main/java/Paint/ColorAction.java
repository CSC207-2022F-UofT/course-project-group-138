package Paint;

import java.awt.*;

public class ColorAction implements PaintAction{
    private final Color color;
    public ColorAction(Color c){
        this.color = c;
    }
    @Override
    public void execute(PaintCanvas canvas) {
        canvas.setPaintColor(color);
    }
}
