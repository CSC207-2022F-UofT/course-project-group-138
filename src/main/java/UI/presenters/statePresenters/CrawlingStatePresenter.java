package UI.presenters.statePresenters;

import UI.presenters.viewModels.PlayerViewModel;
import controllers.TileManager;
import gateways.ImageGateway;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CrawlingStatePresenter implements StatePresenter {
    /**
     * Facade class kinda
     */
    PlayerViewModel playerViewModel;
    BufferedImage currentPlayerImage;
    TileManager tileManager;
    public CrawlingStatePresenter() {
        updatePlayerImage();
    }
    public void render(Graphics2D graphics2D) {
        tileManager.renderTiles(graphics2D);
        // Render Player after tiles
        playerViewModel.updateImage(currentPlayerImage);
        playerViewModel.render(graphics2D);

        // @TODO add render body here (call DungeonRoomPresenter)
    }

    public void setPlayerViewModel(PlayerViewModel playerViewModel) {
        this.playerViewModel = playerViewModel;
    }

    public void setTilePresenter(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    public void updatePlayerImage(){
        currentPlayerImage = ImageGateway.getPlayerImage();
    }
}
