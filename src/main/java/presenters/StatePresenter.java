package presenters;

import Game.State;

import java.awt.*;

public abstract class StatePresenter {
    Graphics graphics;
    State state;
    public StatePresenter(Graphics graphics, State state){
        this.graphics = graphics;
        this.state = state;
    }
    public abstract void render();
}
