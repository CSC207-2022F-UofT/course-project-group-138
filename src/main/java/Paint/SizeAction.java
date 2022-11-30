package Paint;

public class SizeAction implements PaintAction{
    /**
     * A class representing the "change pen size" use case
     */
        private final int size;

    /**
     * @param s - An integer representing the size of this pen
     */
    public SizeAction(int s){
            this.size = s;
        }

    /**
     * Stroke size is set to size
     * @param canvas - The paint canvas
     */
    @Override
        public void execute(PaintCanvas canvas) {
            canvas.setStrokeSize(size);
        }
}
