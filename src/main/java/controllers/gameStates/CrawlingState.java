package controllers.gameStates;

import UI.presenters.viewModels.EnemyViewModel;
import UI.presenters.viewModels.MerchantViewModel;
import controllers.NPCUIManager;
import controllers.TileManager;
import UI.presenters.statePresenters.CrawlingStatePresenter;
import UI.presenters.statePresenters.StatePresenter;
import controllers.DungeonController;
import entities.character.Enemy;
import entities.character.Merchant;
import entities.character.Player;
import entities.dungeon.DungeonRoom;
import settings.Settings;
import useCases.KeyEventHandler;
import useCases.playerUseCases.PlayerCollisionHandler;
import useCases.playerUseCases.PlayerMover;
import UI.presenters.viewModels.PlayerViewModel;
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
    EnemyViewModel enemyViewModel;
    MerchantViewModel merchantViewModel;
    DungeonController dungeonController;
    TileManager tileManager;
    StatePresenter presenter;
    PlayerCollisionHandler playerCollisionHandler;
    NPCUIManager npcuiManager;
    private int roomType = 0;
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
        this.dungeonController = new DungeonController();
        this.playerMover = new PlayerMover(player);
        playerMover.newRoom();
        initializePresenter();
    }
    public void loop() {
        playerMover.move();
        playerViewModel.updatePosition();
        if (enemyViewModel != null) enemyViewModel.updatePosition();
        if (merchantViewModel != null) merchantViewModel.updatePosition();
        playerCollisionHandler.handleTileCollisions(tileManager.getCollisionArray());
        playerCollisionHandler.handleDoorCollisions(tileManager.getDoors(), roomType);
        npcuiManager.update();
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
        npcuiManager = new NPCUIManager();
        this.playerViewModel = viewModel;
        this.presenter = crawlPresenter;
        // Pass this as argument uses Dependency inversion so does not violate CA
        this.playerCollisionHandler =
                new PlayerCollisionHandler(playerViewModel.getCollisionRect(), playerMover, this);
    }

    /**
     * Change the door based on the Door that the player enters.
     *
     * =========PRECONDITION=========: Dungeon is built correctly, and each non start/end room contains min 2 connections and max 6
     * NOTE: This should always work as long as Dungeon is built correctly
     * @param doorType - Door enum
     */
    @Override
    public void changeRoom(Door doorType) {
        // Remove previous room from connections array list first
        List<DungeonRoom> roomList = new ArrayList<>(dungeonController.getConnections());
        try {
            DungeonRoom prev = dungeonController.getCurrentRoom().getPreviousRoom();
            roomList.remove(prev);
        } catch (DungeonRoom.Object404Error ignored) { // No need to do anything
        }
        // Check which door was entered
        switch (doorType){
            case BOTTOM:
                dungeonController.goForward(roomList.get(2));
                break;
            case LEFT:
                /**
                 * This should never throw an exception as long as Dungeon is built correctly
                 */
                try {
                    dungeonController.goBack();
                } catch (DungeonRoom.Object404Error e) {
                    System.out.println("Error! No room to go back to");
                    e.printStackTrace();
                }
                break;
            case RIGHT:
                dungeonController.goForward(roomList.get(0));
                break;
            case TOP_LEFT:
                dungeonController.goForward(roomList.get(3));
                break;
            case TOP_MID:
                dungeonController.goForward(roomList.get(1));
                break;
            case TOP_RIGHT:
                dungeonController.goForward(roomList.get(4));
                break;
        }
        roomType = Math.min(dungeonController.getConnections().size(), 6);
//        roomType = ThreadLocalRandom.current().nextInt(1, 6);
        System.out.println("New Room #: " + acc);
        System.out.println("Current Room has size: " + dungeonController.getConnections().size());
        System.out.println("Enemies? " + dungeonController.getCurrentRoom().hasEnemy());
        System.out.println("Merchants? " + dungeonController.getCurrentRoom().hasMerchant());
        acc++;
        tileManager.changeRoom(roomType - 1);
        getEnemy();
        getMerchant();
        playerMover.newRoom();
    }

    /**
     * Retrieves an enemy from the dungeon if it exists
     */
    public void getEnemy(){
        DungeonRoom currRoom = dungeonController.getCurrentRoom();
        if (currRoom.hasEnemy()) {
            ((CrawlingStatePresenter)presenter).hasEnemy = true;
            // Retrive location from map
            int[] location = tileManager.getEnemyLocation();
            Enemy enemy = currRoom.getEnemy();
            enemy.setX(location[0]);
            enemy.setY(location[1]);
            if (enemyViewModel == null) {
                enemyViewModel = new EnemyViewModel(enemy, Settings.getTileSize());
                ((CrawlingStatePresenter)presenter).setEnemyViewModel(enemyViewModel);
            }
            npcuiManager.spawnEnemy(dungeonController.getCurrentRoom(), enemyViewModel);
        }
        else{
            ((CrawlingStatePresenter)presenter).hasEnemy = false;
            if (enemyViewModel != null){
                enemyViewModel.getEntity().setX(-100);
                enemyViewModel.getEntity().setY(-100);
            }
        }
    }

    /**
     * Retrieves the merchant from the dungeon if it exists
     */
    public void getMerchant(){
        DungeonRoom currRoom = dungeonController.getCurrentRoom();
        if (currRoom.hasMerchant()) {
            ((CrawlingStatePresenter)presenter).hasMerchant = true;
            int[] location = tileManager.getMerchantLocation();
            Merchant merchant = currRoom.getMerchant();
            merchant.setX(location[0]);
            merchant.setY(location[1]);
            System.out.println(merchant.getX());
            System.out.println(merchant.getY());
            if (merchantViewModel == null) {
                merchantViewModel = new MerchantViewModel(merchant, Settings.getTileSize());
                ((CrawlingStatePresenter)presenter).setMerchantViewModel(merchantViewModel);
            }
            npcuiManager.spawnMerchant(dungeonController.getCurrentRoom(), merchantViewModel);
        }
        else{
            ((CrawlingStatePresenter)presenter).hasMerchant = false;
            if (merchantViewModel != null){
                merchantViewModel.getEntity().setX(-100);
                merchantViewModel.getEntity().setY(-100);
            }
        }
    }
}
