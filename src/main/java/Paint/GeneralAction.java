package Paint;

public class GeneralAction implements PaintAction{
    private String action;
    public GeneralAction(String a){
        this.action = a;
    }
    @Override
    public void execute(PaintCanvas canvas) {
        switch (action.toLowerCase()){
            case "clear":
                canvas.clear();
                break;
            case "done":
                canvas.done();
        }
    }
}
