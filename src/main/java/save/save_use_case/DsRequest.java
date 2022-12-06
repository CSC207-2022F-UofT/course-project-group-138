package save.save_use_case;

import entities.character.Player;
import entities.dungeon.Dungeon;

import java.time.LocalDateTime;

public class DsRequest {
    private String fileName;

    private Player player;

    private Dungeon dungeon;

    private LocalDateTime creationTime;

    public DsRequest(String fileName, Player player, Dungeon dungeon, LocalDateTime creationTime) {
        this.fileName = fileName;
        this.player = player;
        this.dungeon = dungeon;
        this.creationTime = creationTime;
    }

    public String getFileName() {
        return fileName;
    }

    void setFileName(String filename) {
        this.fileName = filename;
    }

    public Player getPlayer() {
        return player;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}

