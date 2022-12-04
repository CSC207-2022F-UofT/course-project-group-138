package UI.presenters;

import entities.character.Character;
import useCases.playerUseCases.FlipStrategy;

import java.awt.image.BufferedImage;

public class CharacterViewModel extends ViewModel{
    /**
     * @param character - The character object
     * @param size      - The size of the character, retrieved from Settings
     */
    public CharacterViewModel(Character character, int size) {
        super(character, size);
    }
    /**
     * Updates the image of this character. Must call this method before render method.
     *
     * update: now calls the Flip animation strategy
     */
    public void updateImage(BufferedImage image){
        entityImage = FlipStrategy.getAnimationFrame((Character) entity, image);
    }

}
