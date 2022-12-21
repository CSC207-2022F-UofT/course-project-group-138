package save.save_use_case;

import entities.character.Player;
import entities.dungeon.DungeonRoom;

import java.util.HashMap;
import java.util.List;

public class LoadResponse {

    private String fileName;

    private Player player;

    private HashMap<DungeonRoom, List<DungeonRoom>> map;

    public LoadResponse(String fileName, Player player, HashMap<DungeonRoom, List<DungeonRoom>> map) {
        this.fileName = fileName;
        this.player = player;
        this.map = map;
    }

    public String getFilename() {
        return fileName;
    }
    

    public Player getPlayer() {
        return player;
    }
}
