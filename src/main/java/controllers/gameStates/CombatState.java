package controllers.gameStates;

import UI.presenters.PlayerViewModel;
import UI.presenters.statePresenters.StatePresenter;
import controllers.CombatController;
import entities.character.Enemy;
import entities.character.Player;
import useCases.ClickEventHandler;
import useCases.KeyEventHandler;


//TODO: implement method bodies


public class CombatState implements State{
    /**
     * This class represents the state of the game where the player is in combat.
     * The player cannot move, but can click the Attack button on the screen to perform an attack.
     */

    Player player;
    Enemy enemy;
    PlayerViewModel playerViewModel;

    CombatController combatController;
    StatePresenter presenter;

    /**
     * Constructor. The code responsible for passing control to CombatState will initialize an instance of it
     * @param player             - the player character
     * @param enemy              - the enemy character
     * @param playerViewModel    - the viewmodel responsible for displaying the player
     * @param presenter          - the presenter responsible for displaying the game to the user
     */
    public CombatState(Player player, Enemy enemy, PlayerViewModel playerViewModel, StatePresenter presenter) {
        this.player = player;
        this.enemy = enemy;
        this.playerViewModel = playerViewModel;
        this.combatController = new CombatController(player, enemy);
        this.presenter = presenter;
    }
    public void loop() {
//        combatController.combatTurn();
    }

    /**
     * Passes user key presses to KeyEventHandler.handleCombatStateEvents(code)
     * @param code - keyCode corresponding to the key
     */
    public void keyPressEvents(int code) {
        KeyEventHandler.handleCombatStateEvents(code);
    }

    /**
     * Passes user key presses to KeyEventHandler.handleCombatStateEvents(code)
     * @param code - keyCode corresponding to the key
     */
    public void keyReleasedEvents(int code) {
        KeyEventHandler.handleCombatStateEvents(code);
    }

    /**
     * Passes user clicks to ClickEventHandler.handleCombatStateEvents(code)
     * @param code - clickCode corresponding to the click
     */
    public void clickEvents(int code) {
        ClickEventHandler.handleCombatStateEvents(code);

    }

    @Override
    public StatePresenter getPresenter() {
        return presenter;
    }
}
