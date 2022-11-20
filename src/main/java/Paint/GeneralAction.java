package Paint;

import java.io.IOException;

public class GeneralAction implements PaintAction{
    private String action;
    public GeneralAction(String a){
        this.action = a;
    }
    @Override
    public void execute(PaintCanvas canvas) throws IOException {
        switch (action.toLowerCase()){
            case "clear":
                canvas.clear();
                break;
            case "preview":
                canvas.done();
                canvas.preview();
                break;
            case "done":
                canvas.done();
        }
    }
}
