package controllers.gameStates;

import UI.presenters.statePresenters.StatePresenter;


//TODO: implement method bodies


public class CombatState implements State{
    /**
     * This class represents the state of the game where the player is in combat.
     * The player cannot move, but can click the Attack button on the screen to perform an attack.
     */

    public void loop() {

    }

    /**
     * Currently this method has no body, as the player doesn't move while in combat. Future work on the game may
     * implement mechanics that allow the player to move during combat.
     * @param code - keyCode corresponding to the key
     */
    public void keyPressEvents(int code) {

    }

    /**
     * Currently this method has no body, as the player doesn't move while in combat. Future work on the game may
     * implement mechanics that allow the player to move during combat.
     * @param code - keyCode corresponding to the key
     */
    public void keyReleasedEvents(int code) {

    }

    public void clickEvents(int code) {

    }

    @Override
    public StatePresenter getPresenter() {
        return null;
    }
}
