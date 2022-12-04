package combat;

import entities.character.Enemy;
import entities.character.Player;

// need to somehow take inputs from the player

public class CombatLoop {
    /**
     * A class with a single class method that handles the combat.
     */

    /**
     * A class method that gives turns to player and enemy to attack until one is dead.
     * The player is healed and awarded if they win.
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
        if (PlayerAlive) {                  // If the player won
            player.setHP();                 // heal their hp to full
            int coins = enemy.getCoins();
            player.changeCoins(coins);      // and award them coins
            return true;                    // and return that the player won
        }

        else {                              // If the player is defeated
            return false;                   // EnemyEncounterView handles death animation and screen
        }
    }

}
