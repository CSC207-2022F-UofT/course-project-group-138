package controllers;

import controllers.gameStates.*;
import entities.character.Merchant;

public class StateFactory {
    public State getState(States state) {
        switch (state) {
            case CRAWL:
                return new CrawlingState();
            case COMBAT:
                return new CombatState();
            case MERCHANT:
                return new MerchantState();
            case MENU:
                return new MenuState();
        }
        return new CrawlingState();
    }
}
