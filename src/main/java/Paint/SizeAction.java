package Paint;

public class SizeAction implements PaintAction{
        private int size;
        public SizeAction(int s){
            this.size = s;
        }
        @Override
        public void execute(PaintCanvas canvas) {
            canvas.setStrokeSize(size);
        }
}
