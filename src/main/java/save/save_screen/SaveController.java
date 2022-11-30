package save.save_screen;

import entities.character.Player;
import save.save_use_case.SaveInputBoundry;
import save.save_use_case.SaveRequest;
import save.save_use_case.SaveResponse;

public class SaveController {
    final SaveInputBoundry PLAYER_INPUT;

    public SaveController(SaveInputBoundry playerInput) {
        this.PLAYER_INPUT = playerInput;
    }

    public SaveResponse performSave(String fileName, Player player) {
        SaveRequest saveRequest = new SaveRequest(fileName, player);
        return PLAYER_INPUT.performSave(saveRequest);
    }
}
