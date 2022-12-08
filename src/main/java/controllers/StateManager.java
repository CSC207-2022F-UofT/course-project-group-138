package controllers;

import controllers.gameStates.*;
import entities.character.Enemy;
import entities.character.Merchant;

import java.awt.*;

public class StateManager implements StateChanger{
    State currState;
    public State combatState, crawlingState, menuState, encounterState;
    public void keyPressed(int keyCode){
        currState.keyPressEvents(keyCode);
    }
    public void keyReleased(int keyCode){
        currState.keyReleasedEvents(keyCode);
    }
    public void click(int clickCode){
        currState.clickEvents(clickCode);
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
    @Override
    public void toCrawlingState() {
        currState = crawlingState;
    }
    @Override
    public void toCombatState(Enemy enemy) {
        currState = combatState;
        ((CombatState)combatState).setEnemy(enemy);
    }
    @Override
    public void toEncounterState(Merchant merchant) {
        currState = encounterState;
    }
    @Override
    public void toMenu() {
        currState = menuState;
    }
}