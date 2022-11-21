package presenters;
import character.Player;
import settings.Settings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
/*
    Purpose of this class is to segregate back-end business logic and front-end GUI. Refer to the MVVM architectural
    pattern.

    TLDR: This class (the view model) observes changes from player (the model) and communicates those changes to the
    graphics (the view).
 */
public class PlayerViewModel extends Rectangle {
    private final Player player;
    // Gets the user drawn player image from "res"
    private final Image playerImage = ImageIO.read(new File("res/character.png"));

    public PlayerViewModel(Player player) throws IOException {
        super(player.getx() * Settings.getPlayerSize(), player.gety() * Settings.getPlayerSize(),
                Settings.getPlayerSize(), Settings.getPlayerSize());
        this.player = player;
    }

    /**
     * This should be continuously called from the game loop, so that the view model can observe the changes
     */
    public void updatePosition(){
        super.x = player.getx();
        super.y = player.gety();
    }

    /**
     * This will draw the user's drawn image onto graphics
     * @param graphics - Graphics object in which the player will be drawn.
     */
    public void render(Graphics graphics){
        graphics.drawImage(playerImage, super.x, super.y, super.width, super.height, null);
    }

}
