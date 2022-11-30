package controllers.gameStates;

import UI.presenters.statePresenters.CrawlingStatePresenter;
import UI.presenters.statePresenters.StatePresenter;
import controllers.DungeonController;
import entities.character.Player;
import settings.Settings;
import useCases.playerUseCases.PlayerMover;
import UI.presenters.PlayerViewModel;
import settings.Initializer;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CrawlingState implements State {
    /**
     * This class represents the state of the game where the player is free to move/roam around the map
     * There is no combat in this state, only movement and room transitions between various dungeon rooms.
     *
     * TLDR: Movement state (Non-Combat)
     */
    Player player;
    PlayerMover playerMover;
    PlayerViewModel playerViewModel;
    DungeonController dungeonController;
    StatePresenter presenter;

    /**
     * Creates a MainPlayingState object. Initializes the player, dungeon, playerMover.
     */
    public CrawlingState(){
        super();
        Initializer initializer = new Initializer();
        // The argument passed into the init method may change later...
        initializer.init();
        this.player = initializer.getPlayer();
        this.dungeonController = new DungeonController();
        this.playerMover = new PlayerMover(player);
        this.playerViewModel = new PlayerViewModel(player, Settings.getPlayerSize());
        this.presenter = new CrawlingStatePresenter();
    }

    public void loop() {
        playerMover.move();
        // @TODO call to DungeonRoomController
    }
    /**
     * Updates PlayerMover so that the associated direction boolean will be true
     * @param code - keyCode corresponding to the key
     */
    public void keyPressed(int code) {
        updatePlayerMover(code, true);
    }

    /**
     * Updates PlayerMover so that the associated direciton boolean will be false (since key released)
     * @param code - keyCode corresponding to the key
     */

    public void keyReleased(int code) {
        updatePlayerMover(code, false);
    }

    @Override
    public StatePresenter getPresenter() {
        return presenter;
    }

    public Player getPlayer(){
        return player;
    }

    /**
     * Typical PC controls. WASD for up, left, down, right respectively
     * @param code - keyCode corresponding to the key
     * @param bool - the whether key is pressed or released
     */
    private void updatePlayerMover(int code, boolean bool){
        switch(code) {
            case KeyEvent.VK_W:
                this.playerMover.movingUp(bool);
                break;
            case KeyEvent.VK_A:
                this.playerMover.movingLeft(bool);
                break;
            case KeyEvent.VK_S:
                this.playerMover.movingDown(bool);
                break;
            case KeyEvent.VK_D:
                this.playerMover.movingRight(bool);
                break;
        }
    }
}
