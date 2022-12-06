package controllers;

import useCases.Attack;
import entities.character.Enemy;
import entities.character.Player;

import java.util.List;


public class CombatRound {
    /**
     * A class with a class methods that handles one round of combat.
     */

    /**
     * A class method that handles one round of combat.
     * Player attacks enemy.
     * The player is healed and awarded with coins if they kill the enemy.
     * The return value is used to update the presenter.
     *
     * @param player - player
     * @param enemy  - enemy
     * @return       - a List of ints of length 2. The first entry is the player's HP, the second entry is the enemy's HP
     */
    public static List<Integer> combatRound(Player player, Enemy enemy) {

        List<Integer> resultHP = Attack.taketurn(player, enemy);            // player attacks

        if (!enemy.isAlive()) {                 // If the attack killed the enemy
            player.setHP();                     // heal their hp to full
            int coins = enemy.getCoins();
            int current = player.getCoins();
            player.setCoins(coins + current);  // and award them coins
            return resultHP;
        }

        // We assume at this point enemy is still alive, and they can attack.
        resultHP = Attack.taketurn(enemy, player);
        if (!player.isAlive()) {                // If the attack killed the player
            player.setHP();                     // revert their hp to pre combat
            return resultHP;
        }

        // We assume at this point both are still alive, and return their updated HPs.
        return resultHP;
    }

}
