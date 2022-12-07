package controllers.gameStates;

import UI.presenters.TilePresenter;
import UI.presenters.statePresenters.CrawlingStatePresenter;
import UI.presenters.statePresenters.StatePresenter;
import controllers.DungeonController;
import controllers.game.Engine;
import entities.character.Player;
import entities.dungeon.DungeonTile;
import settings.Settings;
import useCases.KeyEventHandler;
import useCases.playerUseCases.PlayerCollisionHandler;
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
    PlayerCollisionHandler playerCollisionHandler;

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
        // this.dungeonController = new DungeonController();
        this.playerMover = new PlayerMover(player);
        initializePresenter();
    }
    public void loop() {
        playerMover.move();
        playerViewModel.updatePosition();

        // dungeonController = new DungeonController();
        playerCollisionHandler.handleTileCollisions();
        // @TODO call to DungeonRoomController
    }
    /**
     * Updates PlayerMover so that the associated direction boolean will be true
     * @param code - keyCode corresponding to the key
     */
    public void keyPressEvents(int code) {
        KeyEventHandler.handleCrawingStateEvents(code, true, playerMover);
    }
    /**
     * Updates PlayerMover so that the associated direction boolean will be false (since key released)
     * @param code - keyCode corresponding to the key
     */
    public void keyReleasedEvents(int code) {
        KeyEventHandler.handleCrawingStateEvents(code, false, playerMover);
    }

    /**
     * Currently this method has no body, as the player doesn't click while exploring. Future work on the game may
     * implement mechanics that allow the player to click while exploring.
     * @param code - clickCode corresponding to the click
     */
    public void clickEvents(int code) {

    }

    @Override
    public StatePresenter getPresenter() {
        return presenter;
    }
    public Player getPlayer(){
        return player;
    }
    /**
     * Helper Method for initializing the PlayerViewModel and the CrawlingStatePresenter
     */
    private void initializePresenter(){
        PlayerViewModel viewModel = new PlayerViewModel(player, Settings.getPlayerSize());
        TilePresenter tilePresenter = new TilePresenter();
        CrawlingStatePresenter crawlPresenter = new CrawlingStatePresenter();
        crawlPresenter.setPlayerViewModel(viewModel);
        crawlPresenter.setTilePresenter(tilePresenter);
        this.playerViewModel = viewModel;
        this.presenter = crawlPresenter;
        this.playerCollisionHandler = new PlayerCollisionHandler(playerViewModel, playerMover,
                tilePresenter.getCollisionArray());
    }
}
