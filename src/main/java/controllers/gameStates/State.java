package controllers.gameStates;

import UI.presenters.statePresenters.StatePresenter;
import entities.character.Character;
import entities.character.Entity;

public interface State {
    void loop();

    void keyPressEvents(int code);
    void keyReleasedEvents(int code);
    void clickEvents(int code);
    StatePresenter getPresenter();

}
