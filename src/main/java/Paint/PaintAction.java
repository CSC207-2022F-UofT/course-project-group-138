package Paint;

import java.io.IOException;

public interface PaintAction {
    void execute(PaintCanvas canvas) throws IOException;
}
