package controllers;

import entities.character.Enemy;
import entities.character.Player;
import useCases.Attack;
import entities.character.Character;
import useCases.CombatRound;

import java.awt.event.ActionEvent;
import java.util.List;

public class CombatController {
    /**
     * Controller for facillating data between the user interface and CombatLoop
     */

    private final Player player;
    private final Enemy enemy;


    /**
     *  === Constructor ===
     * @param player - character 1
     * @param enemy - character 2
     * @param e     - input
     */
    public CombatController(Player player, Enemy enemy, ActionEvent e) {
        this.player = player;
        this.enemy = enemy;
    }

    /**
     * Passes two characters and user input into Attack.taketurnhp()
     * This method is open for extension, adding a switch statement and a variety of cases allows the controller
     * to respond to a variety of string inputs, such as defending, retreating, or using an item.
     *
     * @param userInput - user input
     * @return A List of ints, first entry is char1's updated hp, second entry is char2's updated hp
     */
    public List<Integer> combatTurn(String userInput) {
        // Does "Attack" need to be replaced with GUI.Button presses?
        List<Integer> updatedHP = null;
        if (userInput.equals("Attack")) {
            updatedHP = CombatRound.combatRound(this.player, this.enemy);
        }
        return updatedHP;
    }


}
