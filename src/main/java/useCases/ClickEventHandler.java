package useCases;

import controllers.game.Engine;
import useCases.playerUseCases.PlayerMover;

import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

public class ClickEventHandler {

//    private userLastClick

    public static void handleCombatStateEvents(int code){

    }
    /**
     * Typical PC controls. WASD for up, left, down, right respectively
     * @param code - keyCode corresponding to the key
     * @param bool - the whether key is pressed or released
     */
    public static void updatePlayerMover(int code, boolean bool, PlayerMover playerMover) {
        switch (code) {
            case MouseEvent.MOUSE_CLICKED:
                playerMover.movingUp(bool);
                break;

        }
    }
}

