package save.save_use_case;

import entities.character.Player;
import entities.dungeon.Dungeon;

// neeed to import the Player Class and inventory class

public class SaveRequest {
    private String fileName;

    private Player player;

    private Dungeon dungeon;

    public SaveRequest(String fileName, Player player, Dungeon dungeon) {
        this.fileName = fileName;
        this.player = player;
        this.dungeon = dungeon;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String filename) {
        this.fileName = filename;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }
}

