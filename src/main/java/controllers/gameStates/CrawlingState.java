package controllers.gameStates;

import controllers.TileManager;
import UI.presenters.statePresenters.CrawlingStatePresenter;
import UI.presenters.statePresenters.StatePresenter;
import controllers.DungeonController;
import entities.character.Player;
import entities.dungeon.DungeonDoor;
import entities.dungeon.DungeonRoom;
import settings.Settings;
import useCases.KeyEventHandler;
import useCases.playerUseCases.PlayerCollisionHandler;
import useCases.playerUseCases.PlayerMover;
import UI.presenters.PlayerViewModel;
import settings.Initializer;
import entities.dungeon.DungeonDoor.Door;

import java.util.ArrayList;
import java.util.List;

public class CrawlingState implements State, RoomSwitcher {
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
    TileManager tileManager;
    StatePresenter presenter;
    PlayerCollisionHandler playerCollisionHandler;
    int acc = 0;

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
        this.dungeonController = new DungeonController();
        this.playerMover = new PlayerMover(player);
        initializePresenter();
    }
    public void loop() {
        playerMover.move();
        playerViewModel.updatePosition();
        playerCollisionHandler.handleTileCollisions(tileManager.getCollisionArray());
        playerCollisionHandler.handleDoorCollisions(tileManager.getDoors());
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
     * Updates PlayerMover so that the associated direciton boolean will be false (since key released)
     * @param code - keyCode corresponding to the key
     */
    public void keyReleasedEvents(int code) {
        KeyEventHandler.handleCrawingStateEvents(code, false, playerMover);
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
        tileManager = new TileManager();
        CrawlingStatePresenter crawlPresenter = new CrawlingStatePresenter();
        crawlPresenter.setPlayerViewModel(viewModel);
        crawlPresenter.setTilePresenter(tileManager);
        this.playerViewModel = viewModel;
        this.presenter = crawlPresenter;
        // Pass this as argument uses Dependency inversion so does not violate CA
        this.playerCollisionHandler =
                new PlayerCollisionHandler(playerViewModel.getCollisionRect(), playerMover, this);
    }

    @Override
    public void changeRoom(Door doorType) {
        List<DungeonRoom> roomList = new ArrayList<>(dungeonController.getConnections());
        try {
            DungeonRoom prev = dungeonController.getCurrentRoom().getPreviousRoom();
            roomList.remove(prev);
        } catch (DungeonRoom.Object404Error ignored) { // No need to do anything
        }
        switch (doorType){
            case BOTTOM:
                try {
                    dungeonController.goBack();
                } catch (DungeonRoom.Object404Error e) {
                    System.out.println("Error! No room to go back to");
                    e.printStackTrace();
                }
                break;
            case LEFT:
                dungeonController.goForward(roomList.get(1));
                break;
            case RIGHT:
                dungeonController.goForward(roomList.get(2));
                break;
            case TOP_LEFT:
                dungeonController.goForward(roomList.get(3));
                break;
            case TOP_MID:
                dungeonController.goForward(roomList.get(0));
                break;
            case TOP_RIGHT:
                dungeonController.goForward(roomList.get(4));
                break;
        }
        System.out.println("New Room #: " + acc);
        System.out.println("next room has size: " + dungeonController.getConnections().size());
        acc++;
        tileManager.changeRoom(dungeonController.getConnections().size());
        playerMover.newRoom();
    }
}
