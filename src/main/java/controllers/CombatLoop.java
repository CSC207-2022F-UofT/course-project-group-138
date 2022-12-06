package controllers;

import useCases.Attack;
import entities.character.Enemy;
import entities.character.Player;

// need to somehow take inputs from the player

public class CombatLoop {
    /**
     * A class with a single class method that handles the combat.
     */

    // TODO implement user input functionality

    /**
     * A class method that gives turns to player and enemy to attack until one is dead.
     * The player is healed and awarded with coins if they win.
     * The intention is that the method that calls CombatLoop will receive a boolean, and call the appropriate presenter
     * from there.
     *
     * @param player - player
     * @param enemy  - enemy
     * @return       - true for player victory, false for player death
     */
    public static boolean combatLoop(Player player, Enemy enemy) {

        boolean PlayerAlive = true;
        boolean EnemyAlive = true;

        while(PlayerAlive && EnemyAlive) {
            EnemyAlive = Attack.taketurn(player, enemy);            // player attacks
            if (EnemyAlive) {                                       // Check if enemy survived
                    PlayerAlive = Attack.taketurn(enemy, player);   // If so, allow enemy to attack
            }
        }

        // Check for victor and call appropriate methods
        if (PlayerAlive) {                     // If the player won
            player.setHP();                    // heal their hp to full
            int coins = enemy.getCoins();
            int current = player.getCoins();
            player.setCoins(coins + current);  // and award them coins
            return true;                       // and return that the player won
        }

        else {                              // If the player is defeated
            return false;                   // EnemyEncounterView handles death animation and screen
        }
    }

}
