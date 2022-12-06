package useCases;

import entities.character.Character;

import java.util.ArrayList;
import java.util.List;

public class Attack {
    /**
     * A class for handling one character attacking another. To be repeatedly called on by a combat loop.
     *
     * Performing an attack would be considered a use case, and thus class Attack is allowed to depend on entities.
     */

    /**
     * Performs an attack using the weapon attack value in the char1's inventory, applying the damage to char2's hp.
     * @param char1 - the character attacking
     * @param char2 - the character being attacked
     * @return - return whether or not the attack resulted in a kill
     */
    public static boolean taketurn(Character char1, Character char2) {
        int damage = char1.attack();
        char2.changeHP(-damage);
        return char2.isAlive();
    }

    /**
     * Performs an attack using the weapon attack value in the char1's inventory, applying the damage to char2's hp.
     * Returns the current HP of both characters instead.
     * @param char1 - the character attacking
     * @param char2 - the character being attacked
     * @return - return whether or not the attack resulted in a kill
     */
     public static List<Integer> taketurnhp(Character char1, Character char2) {
        int damage = char1.attack();
        char2.changeHP(-damage);
        List<Integer> resulting_HP = new ArrayList<>();
        resulting_HP.add(char1.getHP());
        resulting_HP.add(char2.getHP());
        return resulting_HP;
     }

}
