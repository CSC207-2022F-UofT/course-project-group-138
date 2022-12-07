package useCases;

import java.awt.event.MouseEvent;

public class ClickEventHandler {

    public static String handleCombatStateEvents(int code){
        return updateCombatClicks(code);
    }

    // TODO: the presenter for combat needs to modify this method to only respond to clicks within a specified region
    /**
     * Click anywhere to return "Attack"
     * @param code - clickCode corresponding to the code
     */
    private static String updateCombatClicks(int code) {
        if (code == MouseEvent.MOUSE_CLICKED) {
            return "Attack";
        }
        return null;
    }

}

