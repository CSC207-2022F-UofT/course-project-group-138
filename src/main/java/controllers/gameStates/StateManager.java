package controllers.gameStates;

import java.awt.*;

public class StateManager {
    State currState;
    public void keyPressed(int keyCode){
        currState.keyPressEvents(keyCode);
    }
    public void keyReleased(int keyCode){
        currState.keyReleasedEvents(keyCode);
    }
    public void setCurrState(State newState){
        currState = newState;
    }
    public void loop(){
        currState.loop();

    }
    public void renderState(Graphics2D graphics){
        currState.getPresenter().render(graphics);
    }

}