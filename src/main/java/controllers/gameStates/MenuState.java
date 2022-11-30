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

    public void keyPressed(int code) {

    }


    public void keyReleased(int code) {

    }

    @Override
    public StatePresenter getPresenter() {
        return presenter;
    }
}
