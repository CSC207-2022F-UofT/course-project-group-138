package UI.presenters;

import UI.presenters.ViewModel;
import entities.character.Character;
import entities.dungeon.DungeonTile;

import java.awt.image.BufferedImage;

public class TileViewModel extends ViewModel {
    private BufferedImage tileImage;
    private DungeonTile tile;

    /**
     * Not to be called, contains code so that children can inherit.
     *
     * @param character - The character object
     * @param size      - The size of the character, retrieved from Settings
     */
    public TileViewModel(Character character, int size) {
        super(character, size);
    }

    public void setTileImage(BufferedImage tileImage){
        this.tileImage = tileImage;
    }

    public BufferedImage getTileImage() {
        return tileImage;
    }
}
