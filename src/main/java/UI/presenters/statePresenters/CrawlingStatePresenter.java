package UI.presenters.statePresenters;

import UI.presenters.viewModels.EnemyViewModel;
import UI.presenters.viewModels.MerchantViewModel;
import UI.presenters.viewModels.PlayerViewModel;
import controllers.TileManager;
import gateways.ImageGateway;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CrawlingStatePresenter implements StatePresenter {
    /**
     * This is the main presenter for the CrawlingState. It will call methods necessary to render the CharacterViewModels
     * and tiles
     */
    public boolean hasMerchant;
    public boolean hasEnemy;
    /**
     * Mainly facade Class, implementation is further down the call stack
     */
    PlayerViewModel playerViewModel;
    BufferedImage currentPlayerImage;
    EnemyViewModel enemyViewModel;
    MerchantViewModel merchantViewModel;
    TileManager tileManager;

    /**
     ==== Constructor ====
     Initializes the player image
     */
    public CrawlingStatePresenter() {
        updatePlayerImage();
    }

    /**
     * Renders in the following order: Tiles --> enemy --> merchant --> player.
     * @param graphics2D - The Java Graphics2D object
     */
    public void render(Graphics2D graphics2D) {
        tileManager.renderTiles(graphics2D);
        // Render Player after tiles
        playerViewModel.updateImage(currentPlayerImage);
        // Render the view models
        if (enemyViewModel != null && hasEnemy) enemyViewModel.render(graphics2D);
        if (merchantViewModel != null && hasMerchant) merchantViewModel.render(graphics2D);
        playerViewModel.render(graphics2D);
    }

    /**
     * Sets the reference to playerviewmodel
     * @param playerViewModel - The Player's viewmodel
     */
    public void setPlayerViewModel(PlayerViewModel playerViewModel) {
        this.playerViewModel = playerViewModel;
    }

    /**
     * Sets the reference to enemyviewmodel (ViewModel is shared between all enemies to save memory)
     * @param enemyViewModel - The enemy view model (Note, this does not vary per enemy.)
     */
    public void setEnemyViewModel(EnemyViewModel enemyViewModel) {
        this.enemyViewModel = enemyViewModel;
    }

    /**
     * Sets the reference to enemyviewmodel (ViewModel is shared between all merchants to save memory)
     * @param merchantViewModel - The Merchant's view model (Does not vary per merchant)
     */
    public void setMerchantViewModel(MerchantViewModel merchantViewModel) {
        this.merchantViewModel = merchantViewModel;
    }

    /**
     * Sets the reference to the TileManager (TileManager is responsible to rendering EVERY TILE)
     * @param tileManager - The main tile controller, however it holds a reference to TilePresenter.
     */
    public void setTileManager(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    /**
     * Retrives and sets the player image from the Image Gateway class
     */
    public void updatePlayerImage(){
        currentPlayerImage = ImageGateway.getPlayerImage();
    }
}
