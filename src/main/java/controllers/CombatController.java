package controllers;

import useCases.Attack;
import entities.character.Character;

import java.awt.event.ActionEvent;
import java.util.List;

public class CombatController {
    /**
     * Controller for facillating data between the user interface and CombatLoop
     */

    /**
     * Passes two characters and user input into Attack.taketurnhp()
     * @param userInput
     */
    public void combatTurn(Character char1, Character char2, String userInput) {
        // TODO: Replace String with GUI.Button presses
        if (userInput.equals("Attack")) {
            List<Integer> updatedHP = Attack.taketurn(char1, char2);
        }
    }

    public CombatController(ActionEvent e) {

    }
}
