package UI.presenters.viewModels;

import entities.character.Entity;

import javax.swing.text.View;
import java.awt.image.BufferedImage;

public class MerchantViewModel extends ViewModel {
    /**
     * Not to be called, contains code so that children can inherit.
     *
     * @param entity - The character object
     * @param size   - The size of the character, retrieved from Settings
     */
    public MerchantViewModel(Entity entity, int size) {
        super(entity, size);
    }

    @Override
    public void updateImage(BufferedImage image) {
        this.entityImage = image;
    }
}
