package presenters;

import game.CrawlingState;
import game.State;

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
