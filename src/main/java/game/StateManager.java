package Game;

import java.util.EmptyStackException;
import java.util.Stack;

public class StateManager {
    State currState;
    public void keyPressed(int keyCode){
        currState.keyPressed(keyCode);
    }
    public void keyReleased(int keyCode){
        currState.keyReleased(keyCode);
    }
    public void setCurrState(State newState){
        currState = newState;
    }
    public void loop(){
        currState.loop();
    }

}