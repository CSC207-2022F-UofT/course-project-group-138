package UI.presenters;

import UI.presenters.ViewModel;
import entities.character.Character;
import entities.dungeon.DungeonTile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TileViewModel extends ViewModel {

    /**
     *
     * @param character - The character object
     * @param size      - The size of the character, retrieved from Settings
     */
    public TileViewModel(Character character, int size) {
        super(character, size);
    }

    @Override
    public void updateImage(BufferedImage image) {

    }
}
