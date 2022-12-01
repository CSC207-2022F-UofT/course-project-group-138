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
        // Call the initializer
        Initializer initializer = new Initializer();
        initializer.init();
        this.player = initializer.getPlayer();
        // @TODO uncomment below code when dungeonController is done
        //this.dungeonController = new DungeonController();
        this.playerMover = new PlayerMover(player);
        initializePresenter();
    }

    public void loop() {
        playerMover.move();
        playerViewModel.updatePosition();
        // @TODO call to DungeonRoomController
    }
    /**
     * Updates PlayerMover so that the associated direction boolean will be true
     * @param code - keyCode corresponding to the key
     */
    public void keyPressEvents(int code) {
        updatePlayerMover(code, true);
    }

    /**
     * Updates PlayerMover so that the associated direciton boolean will be false (since key released)
     * @param code - keyCode corresponding to the key
     */

    public void keyReleasedEvents(int code) {
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

    /**
     * Helper Method for initializing the PlayerViewModel and the CrawlingStatePresenter
     */
    private void initializePresenter(){
        PlayerViewModel viewModel = new PlayerViewModel(player, Settings.getPlayerSize());
        CrawlingStatePresenter crawlPresenter = new CrawlingStatePresenter();
        crawlPresenter.setPlayerViewModel(viewModel);
        this.playerViewModel = viewModel;
        this.presenter = crawlPresenter;
    }
}
