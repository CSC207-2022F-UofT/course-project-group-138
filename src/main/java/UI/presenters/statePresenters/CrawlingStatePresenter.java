package UI.presenters.statePresenters;

import UI.presenters.PlayerViewModel;
import controllers.gameStates.CrawlingState;
import controllers.gameStates.State;

import java.awt.*;

public class CrawlingStatePresenter extends StatePresenter {
    /**
     * Facade class kinda
     */
    PlayerViewModel playerViewModel;
    public CrawlingStatePresenter(Graphics graphics, State state) {
        super(graphics, state);
        playerViewModel = new PlayerViewModel(((CrawlingState) state).getPlayer());
    }
    @Override
    public void render() {
        playerViewModel.updatePlayerImage();
        playerViewModel.render(graphics);
        // @TODO add render body here (call DungeonRoomPresenter)
    }
}
