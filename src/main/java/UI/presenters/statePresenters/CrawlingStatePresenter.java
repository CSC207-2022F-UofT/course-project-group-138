package UI.presenters.statePresenters;

import UI.presenters.PlayerViewModel;
import controllers.gameStates.CrawlingState;
import controllers.gameStates.State;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CrawlingStatePresenter extends StatePresenter {
    /**
     * Facade class kinda
     */
    PlayerViewModel playerViewModel;
    Image playerImage;
    public CrawlingStatePresenter(Graphics graphics, State state) {
        super(graphics, state);
        playerViewModel = new PlayerViewModel(((CrawlingState) state).getPlayer());
        updatePlayerImage();
    }
    @Override
    public void render() {
        playerViewModel.updateImage(playerImage);
        playerViewModel.render(graphics);
        // @TODO add render body here (call DungeonRoomPresenter)
    }
    public void updatePlayerImage(){
        try {
            playerImage = ImageIO.read(new File("res/characters.png"));
        } catch (IOException e){
            System.out.println("Error retrieving characters.png");
        }
    }
}
