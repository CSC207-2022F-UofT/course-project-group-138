package Game;

public class LoopOutline {

    /*
    initialization
    1. generate map
    2. initialize player position, prompting drawing program for player
    3. initialize player inventory, prompting drawing program for weapon & armor
    4. prompt drawing program for enemy & merchant
     */

    /*
    main loop
    action:
        a. check if any action key is pressed; if so, update player location
            i. check if the player hit the wall; if so, stop moving
            ii. check if the player is at the end of a hallway; if so, room transition
            iii. check if the player walked into merchant/enemy range; if so, enter encounter loop
            (after attack loop, update player position to outside of npc range (or not if key is required for interaction))
            (if true is returned, npc is removed from the room)
        b. check if the menu key is pressed; if so, enter menu loop
     */

    /*
    encounter loop
    action:
        a. check if npc hp is 0, if so, exit encounter loop to return to the main loop (return true)
        b. check if player hp is 0; if so, enter game end
        b. check if any button is pressed; if so, perform the action according to the button
            i. if quit is pressed, exit encounter loop to return to the main loop (return false)
     */

    /*
    menu loop
    action:
        a. check if any button is pressed; if so, perform the action according to the button
     */

    /*
    game end
    1. call game end screen
    2. initializing player position and health
     */

}
