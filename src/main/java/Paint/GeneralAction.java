package Paint;

import java.io.IOException;

/**
 * A General Action is a non paint related action such as clear, preview, done, save, etc.
 */
public class GeneralAction implements PaintAction{
    private final String action;
    public GeneralAction(String a){
        this.action = a;
    }

    /**
     * Determines what action to do depending on the text on the JButton.
     *
     * IMPORTANT: Changes to the JButton text WILL affect the result of this method.
     * @param canvas - the paint canvas
     * @throws IOException - canvas.done() may throw an IOexception when saving to a file
     */
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
