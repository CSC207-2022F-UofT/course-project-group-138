package UI.presenters.statePresenters;

import UI.presenters.PlayerViewModel;
import controllers.gameStates.CrawlingState;
import controllers.gameStates.State;
import gateways.ImageGateway;
import useCases.BImageStrategy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CrawlingStatePresenter implements StatePresenter {
    /**
     * Facade class kinda
     */
    PlayerViewModel playerViewModel;
    BufferedImage playerImage;
    public CrawlingStatePresenter() {
        updatePlayerImage();
    }
    public void render(Graphics2D graphics) {
        playerViewModel.updateImage(playerImage);
        playerViewModel.render(graphics);
        // @TODO add render body here (call DungeonRoomPresenter)
    }

    public void setPlayerViewModel(PlayerViewModel playerViewModel) {
        this.playerViewModel = playerViewModel;
    }
    public void updatePlayerImage(){
        playerImage = ImageGateway.getPlayerImage();
    }
}
