package controllers.gameStates;

import UI.presenters.statePresenters.MenuStatePresenter;
import UI.presenters.statePresenters.StatePresenter;
import useCases.KeyEventHandler;

// todo: after chlicking done on paint it switches to crawling state
// todo: add popup on paint where if u skip drawing the character it goes to crawling state

public class MenuState implements State {
    StatePresenter presenter;
    public MenuState(){
        this.presenter = new MenuStatePresenter();
    }
    public void loop() {
    }

    public void keyPressEvents(int code) {
        // todo: add checking for menu version
        KeyEventHandler.handleMenuStateEvents(code);
    }


    public void keyReleasedEvents(int code) {
        // todo: add checking for menu version
        KeyEventHandler.handleMenuStateEvents(code);
    }

    @Override
    public void clickEvents(int code) {

    }

    @Override
    public StatePresenter getPresenter() {
        return presenter;
    }

}