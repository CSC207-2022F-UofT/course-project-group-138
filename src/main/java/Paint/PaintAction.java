package Paint;

import java.io.IOException;

/**
 * Interface for button actions
 */
public interface PaintAction {
    void execute(PaintCanvas canvas) throws IOException;
}
