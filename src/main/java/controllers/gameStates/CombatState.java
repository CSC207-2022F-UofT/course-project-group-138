package controllers.gameStates;

import UI.presenters.statePresenters.CombatStatePresenter;
import UI.presenters.viewModels.PlayerViewModel;
import UI.presenters.statePresenters.StatePresenter;
import controllers.CombatController;
import entities.character.Enemy;
import entities.character.Player;
import settings.Initializer;
import useCases.ClickEventHandler;
import useCases.KeyEventHandler;


//TODO: implement method bodies


public class CombatState implements State{
    /**
     * This class represents the state of the game where the player is in combat.
     * The player cannot move, but can click the Attack button on the screen to perform an attack.
     * The player can still press non movement keys for non movement actions.
     */

    Player player;
    Enemy enemy;
    CombatController combatController;
    StatePresenter presenter;

    /**
     * Constructor. The code responsible for passing control to CombatState will initialize an instance of it
     * @param enemy              - the enemy character
     */
    public CombatState(Enemy enemy) {
        this.player = Initializer.getPlayer();
        this.enemy = enemy;
        this.combatController = new CombatController(player, enemy);
        this.presenter = new CombatStatePresenter();
    }

    public CombatState() {
        this.player = Initializer.getPlayer();
        this.presenter = new CombatStatePresenter();
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
        combatController = new CombatController(player, enemy);
    }

    public void loop() {
        combatController.combatTurn();
        // TODO update the presenter (not yet implemented), something like combatPresenter.updatePresenter();
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
