package controllers.gameStates;

import UI.presenters.statePresenters.MenuStatePresenter;
import UI.presenters.statePresenters.StatePresenter;

import java.awt.*;

public class MenuState implements State {
    StatePresenter presenter;
    public MenuState(){
        this.presenter = new MenuStatePresenter();
    }
    public void loop() {
    }

    public void keyPressEvents(int code) {

    }


    public void keyReleasedEvents(int code) {

    }

    public void clickEvents(int code) {

    }

    @Override
    public StatePresenter getPresenter() {
        return presenter;
    }
}
