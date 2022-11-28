package presenters;

import Game.MainPlayingState;
import Game.State;

import java.awt.*;

public class PlayingStatePresenter extends StatePresenter {
    PlayerViewModel playerViewModel;
    public PlayingStatePresenter(Graphics graphics, State state) {
        super(graphics, state);
        playerViewModel = new PlayerViewModel(((MainPlayingState) state).getPlayer());
    }
    @Override
    public void render() {
        playerViewModel.updatePlayerImage();
        playerViewModel.render(graphics);
        // @TODO add render body here (call DungeonPresenter)
    }
}
