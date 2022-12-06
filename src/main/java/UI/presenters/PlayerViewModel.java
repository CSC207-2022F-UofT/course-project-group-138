package UI.presenters;

import entities.character.Character;

/*
    Purpose of this class is to segregate back-end business logic and front-end GUI. Refer to the MVVM architectural
    pattern.

    TLDR: This class (the view model) observes changes from player (the model) and communicates those changes to the
    graphics (the view).
 */
public class PlayerViewModel extends CharacterViewModel{
    /**
     * Constructs a PlayerViewModel object.
     * @param character - This should be an instance of Player
     * @param size - The size of the player, retrieved from Settings
     */
    public PlayerViewModel(Character character, int size) {
        super(character, size);
    }

}
