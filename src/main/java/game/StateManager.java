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

}
