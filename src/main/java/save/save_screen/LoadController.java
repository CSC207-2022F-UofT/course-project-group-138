package save.save_screen;

import save.save_use_case.LoadInputBoundary;
import save.save_use_case.LoadRequest;
import save.save_use_case.LoadResponse;

public class LoadController {

    final LoadInputBoundary PLAYER_INPUT;

    public LoadController(LoadInputBoundary playerInput) {
        this.PLAYER_INPUT = playerInput;
    }


    public LoadResponse performLoad(String filename, boolean quickLoad) {
        if (quickLoad) {
            LoadRequest loadRequest = new LoadRequest(true);
            return PLAYER_INPUT.performQuickLoad(loadRequest);
        }
        else {
            LoadRequest loadRequest = new LoadRequest(filename);
            return PLAYER_INPUT.performLoad(loadRequest);
        }
    }
}
