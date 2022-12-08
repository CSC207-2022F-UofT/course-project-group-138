package save.save_use_case;

import entities.character.Player;
import entities.dungeon.Dungeon;

public class LoadResponse {

    private String fileName;

    private Player player;

    private Dungeon dungeon;

    public LoadResponse(String fileName, Player player, Dungeon dungeon) {
        this.fileName = fileName;
        this.player = player;
        this.dungeon = dungeon;
    }

    public String getFilename() {
        return fileName;
    }

    void setFilename(String fileName) {
        this.fileName = fileName;
    }

    public Player getPlayer() {
        return player;
    }
}
