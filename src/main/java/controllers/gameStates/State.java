package controllers.gameStates;

import UI.presenters.statePresenters.StatePresenter;

import java.awt.*;

public interface State {
    void loop();
    void keyPressed(int code);
    void keyReleased(int code);
    StatePresenter getPresenter();

}
