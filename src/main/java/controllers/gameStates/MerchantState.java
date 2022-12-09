package controllers.gameStates;

import UI.presenters.statePresenters.EncounterStatePresenter;
import UI.presenters.statePresenters.StatePresenter;

public class MerchantState implements State {
    StatePresenter presenter;
    public MerchantState(){
        this.presenter = new EncounterStatePresenter();
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
