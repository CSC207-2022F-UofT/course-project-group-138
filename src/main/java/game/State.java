package Game;

public abstract class State {
    protected abstract void loop();
    protected abstract void render();
    protected abstract void keyPressed(int code);
    protected abstract void keyReleased(int code);
}
