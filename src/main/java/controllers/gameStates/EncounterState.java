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

    public void keyPressed(int code) {

    }


    public void keyReleased(int code) {

    }

    @Override
    public StatePresenter getPresenter() {
        return presenter;
    }
}
