package UI.presenters.statePresenters;

import UI.presenters.viewModels.EnemyViewModel;
import UI.presenters.viewModels.MerchantViewModel;
import UI.presenters.viewModels.PlayerViewModel;
import controllers.TileManager;
import gateways.ImageGateway;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CrawlingStatePresenter implements StatePresenter {
    public boolean hasMerchant;
    public boolean hasEnemy;
    /**
     * Facade class kinda
     */
    PlayerViewModel playerViewModel;
    BufferedImage currentPlayerImage;
    EnemyViewModel enemyViewModel;
    MerchantViewModel merchantViewModel;
    TileManager tileManager;
    public CrawlingStatePresenter() {
        updatePlayerImage();
    }
    public void render(Graphics2D graphics2D) {
        tileManager.renderTiles(graphics2D);
        // Render Player after tiles
        playerViewModel.updateImage(currentPlayerImage);
        // Render the view models
        if (enemyViewModel != null && hasEnemy) enemyViewModel.render(graphics2D);
        if (merchantViewModel != null && hasMerchant) merchantViewModel.render(graphics2D);
        playerViewModel.render(graphics2D);
        // @TODO add render body here (call DungeonRoomPresenter)
    }

    public void setPlayerViewModel(PlayerViewModel playerViewModel) {
        this.playerViewModel = playerViewModel;
    }

    public void setEnemyViewModel(EnemyViewModel enemyViewModel) {
        this.enemyViewModel = enemyViewModel;
    }

    public void setMerchantViewModel(MerchantViewModel merchantViewModel) {
        this.merchantViewModel = merchantViewModel;
    }

    public void setTilePresenter(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    public void updatePlayerImage(){
        currentPlayerImage = ImageGateway.getPlayerImage();
    }
}
