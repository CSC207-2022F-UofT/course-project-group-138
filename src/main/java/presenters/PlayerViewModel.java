package presenters;
import character.Player;

import java.awt.*;

public class PlayerViewModel extends Rectangle {
    private final Player player;

    public PlayerViewModel(Player player){
        super(player.getx() * Settings.getPlayerSize(), player.gety() * Settings.getPlayerSize(),
                Settings.getPlayerSize(), Settings.getPlayerSize());
        this.player = player;
    }
    public void updatePosition(){
        super.x = player.getx();
        super.y = player.gety();
    }


}
