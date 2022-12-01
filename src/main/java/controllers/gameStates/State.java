package controllers.gameStates;

import UI.presenters.statePresenters.StatePresenter;

public interface State {
    void loop();
    void keyPressEvents(int code);
    void keyReleasedEvents(int code);
    StatePresenter getPresenter();

}
