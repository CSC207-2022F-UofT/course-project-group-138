package Game;

import javax.swing.*;
import Game.Engine;

// @TODO name this class the name of the game
public class Game {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Engine.start();
            }
        });
    }
}
