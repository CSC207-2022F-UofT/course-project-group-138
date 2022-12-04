package controllers.gameStates;

import UI.presenters.statePresenters.EncounterStatePresenter;
import UI.presenters.statePresenters.StatePresenter;

import java.awt.*;

public class EncounterState implements State {
    StatePresenter presenter;
    public EncounterState(){
        this.presenter = new EncounterStatePresenter();
    }
    public void loop() {

    }

    public void keyPressEvents(int code) {

    }


    public void keyReleasedEvents(int code) {

    }

    @Override
    public StatePresenter getPresenter() {
        return presenter;
    }
}
