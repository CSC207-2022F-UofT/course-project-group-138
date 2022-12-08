package controllers;

import controllers.gameStates.*;

public class StateFactory {
    public State getState(States state) {
        switch (state) {
            case CRAWL:
                return new CrawlingState();
            case COMBAT:
                return new CombatState();
            case MERCHANT:
                return new EncounterState();
            case MENU:
                return new MenuState();
        }
        return new CrawlingState();
    }
}
