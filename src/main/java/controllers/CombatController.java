package controllers;

import useCases.Attack;
import entities.character.Character;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

//TODO: make it implement State, make State have a click method, make all states have an empty click
public class CombatController {
    /**
     * Controller for facillating data between the user interface and CombatLoop
     */

    /**
     * Passes two characters and user input into Attack.taketurnhp()
     * @param char1     - Character that attacks first (player)
     * @param char2     - Character that attacks second (enemy)
     * @param userInput - user input
     * @return A List of ints, first entry is char1's updated hp, second entry is char2's updated hp
     */
    public List<Integer> combatTurn(Character char1, Character char2, String userInput) {
        // TODO: Replace String with GUI.Button presses
        List<Integer> updatedHP = null;
        if (userInput.equals("Attack")) {
            updatedHP = Attack.taketurn(char1, char2);
        }
        return updatedHP;
    }

    /**
     * Constructor
     * @param char1
     * @param char2
     * @param e
     */
    public CombatController(Character char1, Character char2, ActionEvent e) {
        combatTurn(char1, char2, "Attack");
    }
}
