package UI.presenters.statePresenters;

import UI.presenters.PlayerViewModel;
import controllers.gameStates.CrawlingState;
import controllers.gameStates.State;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CrawlingStatePresenter implements StatePresenter {
    /**
     * Facade class kinda
     */
    PlayerViewModel playerViewModel;
    Image playerImage;
    public CrawlingStatePresenter() {
        updatePlayerImage();
    }
    public void render(Graphics graphics) {
        playerViewModel.updateImage(playerImage);
        playerViewModel.render(graphics);
        // @TODO add render body here (call DungeonRoomPresenter)
    }

    public void setPlayerViewModel(PlayerViewModel playerViewModel) {
        this.playerViewModel = playerViewModel;
    }
    public void updatePlayerImage(){
        try {
            playerImage = ImageIO.read(new File("src/main/res/characters.png"));
        } catch (IOException e){
            System.out.println("Error retrieving characters.png");
            e.printStackTrace();
        }
    }
}
