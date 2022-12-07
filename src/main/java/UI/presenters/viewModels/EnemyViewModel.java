package UI.presenters.viewModels;

import UI.presenters.viewModels.ViewModel;
import entities.character.Character;
import entities.character.Entity;

import java.awt.image.BufferedImage;

public class EnemyViewModel extends CharacterViewModel {
    /**
     * Not to be called, contains code so that children can inherit.
     *
     * @param entity - The character object
     * @param size   - The size of the character, retrieved from Settings
     */
    boolean animated;
    public EnemyViewModel(Character enemy, int size) {
        super(enemy, size);
    }
    @Override
    public void updateImage(BufferedImage image) {
        if (animated){

        }
        else{
            this.entityImage = image;
        }
    }
}
