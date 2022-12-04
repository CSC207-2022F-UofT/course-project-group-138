package UI.presenters.statePresenters;

import UI.presenters.PlayerViewModel;
import controllers.gameStates.CrawlingState;
import controllers.gameStates.State;
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
        try {
            Image img = ImageIO.read(new File("src/main/res/characters.png"));
            playerImage = BImageStrategy.toBufferedImage(img);
        } catch (IOException e){
            System.out.println("Error retrieving characters.png");
            e.printStackTrace();
        }
    }
}
