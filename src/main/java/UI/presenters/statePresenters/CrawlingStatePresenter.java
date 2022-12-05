package UI.presenters.statePresenters;

import UI.presenters.PlayerViewModel;
import UI.presenters.TilePresenter;
import gateways.ImageGateway;
import settings.Settings;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CrawlingStatePresenter implements StatePresenter {
    /**
     * Facade class kinda
     */
    PlayerViewModel playerViewModel;
    BufferedImage currentPlayerImage;
    TilePresenter tilePresenter;
    public CrawlingStatePresenter() {
        updatePlayerImage();
    }
    public void render(Graphics2D graphics2D) {
        tilePresenter.renderTiles(graphics2D);
        // Render Player after tiles
        playerViewModel.updateImage(currentPlayerImage);
        playerViewModel.render(graphics2D);

        // @TODO add render body here (call DungeonRoomPresenter)
    }

    public void setPlayerViewModel(PlayerViewModel playerViewModel) {
        this.playerViewModel = playerViewModel;
    }

    public void setTilePresenter(TilePresenter tilePresenter) {
        this.tilePresenter = tilePresenter;
    }

    public void updatePlayerImage(){
        currentPlayerImage = ImageGateway.getPlayerImage();
    }
}
