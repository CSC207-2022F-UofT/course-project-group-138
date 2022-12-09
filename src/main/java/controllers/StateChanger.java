package controllers;

import entities.character.Enemy;
import entities.character.Merchant;

public interface StateChanger {
    void toCrawlingState();
    void toCombatState(Enemy enemy);
    void toEncounterState(Merchant merchant);
    void toMenu();
}
