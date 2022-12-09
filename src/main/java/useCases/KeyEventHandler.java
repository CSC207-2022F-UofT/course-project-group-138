package useCases;

import controllers.LowBalanceException;
import controllers.MerchantController;
import controllers.game.Engine;
import useCases.playerUseCases.PlayerMover;

import java.awt.event.KeyEvent;

public class KeyEventHandler {
    private static final int MERCHANT_CODE = 0;
    private static int merchantCode = 0;

    public static void handleCrawingStateEvents(int code, boolean bool, PlayerMover playerMover){
        updatePlayerMover(code, bool, playerMover);
        checkEscape(code);
    }

    public static void handleCombatStateEvents(int code) {
        checkEscape(code);
    }
    public static void handleMerchantStateEvents(int code, MerchantController merchantController) {
        try {
            merchantController.purchase();
        } catch (LowBalanceException e) {

        }
        checkEscape(code);
    }

    /**
     * Typical PC controls. WASD for up, left, down, right respectively
     * @param code - keyCode corresponding to the key
     * @param bool - the whether key is pressed or released
     */
    public static void updatePlayerMover(int code, boolean bool, PlayerMover playerMover){
        switch(code) {
            case KeyEvent.VK_W:
                playerMover.movingUp(bool);
                break;
            case KeyEvent.VK_A:
                playerMover.movingLeft(bool);
                break;
            case KeyEvent.VK_S:
                playerMover.movingDown(bool);
                break;
            case KeyEvent.VK_D:
                playerMover.movingRight(bool);
                break;
        }
    }


    /**
     * Quit if player presses escape. In the future, this should pause the game, prompt player
     * with several options
     * @param code - keycode of the keypress
     */
    public static void checkEscape(int code){
        if (code == KeyEvent.VK_ESCAPE) {
            // Closes application when user presses escape (May change later)
            Engine.quit();
        }
    }
}
