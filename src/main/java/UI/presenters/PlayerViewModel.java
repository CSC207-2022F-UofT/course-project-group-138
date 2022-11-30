package UI.presenters;

import entities.character.Player;
import org.jetbrains.annotations.NotNull;
import settings.Settings;

import java.awt.*;
/*
    Purpose of this class is to segregate back-end business logic and front-end GUI. Refer to the MVVM architectural
    pattern.

    TLDR: This class (the view model) observes changes from player (the model) and communicates those changes to the
    graphics (the view).
 */
public class PlayerViewModel extends Rectangle {
    //@TODO add collide method, and make this class abstract
    private final Player player;
    // Gets the user drawn player image from "res"
    private Image playerImage;
    public PlayerViewModel(Player player) {
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
     * Updates the image of this character. Must call this method before render method.
     */
    public void updateImage(Image image){
        playerImage = image;
    }
    /**
     * This will draw the user's drawn image onto graphics
     * @param graphics - Graphics object in which the player will be drawn.
     */
    public void render(@NotNull Graphics graphics){
        graphics.drawImage(playerImage, super.x, super.y, super.width, super.height, null);
    }

}
