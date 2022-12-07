package controllers;

import entities.character.Enemy;
import entities.character.Player;
import useCases.CombatRound;

import java.util.List;

public class CombatController {
    /**
     * Controller for facillating data between the user interface and CombatLoop
     */

    private final Player player;
    private final Enemy enemy;
    private static String userInput;


    /**
     *  === Constructor ===
     * @param player - character 1
     * @param enemy - character 2
     */
    public CombatController(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    /**
     * Getter for userInput
     * @return userInput - string representation of the user's click
     */
    public String getUserInput() {
        return userInput;
    }

    /**
     * Setter for userInput
     * @param userinput - string representation of the user's click
     */
    public static void setUserInput(String userinput) {
        userInput = userinput;
    }

    /**
     * Passes two characters and user input into Attack.taketurnhp()
     * This method is open for extension, adding a switch statement and a variety of cases allows the controller
     * to respond to a variety of string inputs, such as defending, retreating, or using an item.
     *
     * @return A List of ints, first entry is char1's updated hp, second entry is char2's updated hp
     */
    public List<Integer> combatTurn() {
        // Does "Attack" need to be replaced with GUI.Button presses?
        List<Integer> updatedHP = null;
        if (userInput.equals("Attack")) {
            updatedHP = CombatRound.combatRound(this.player, this.enemy);
        }
        return updatedHP;
    }


}
