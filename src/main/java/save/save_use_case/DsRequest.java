package save.save_use_case;

import entities.character.Player;
import entities.dungeon.Dungeon;
import entities.dungeon.DungeonRoom;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class DsRequest {
    private String fileName;

    private Player player;

    private HashMap<DungeonRoom, List<DungeonRoom>> map;

    private LocalDateTime creationTime;

    public DsRequest(String fileName, Player player, HashMap<DungeonRoom, List<DungeonRoom>> map, LocalDateTime creationTime) {
        this.fileName = fileName;
        this.player = player;
        this.map = map;
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

    public HashMap<DungeonRoom, List<DungeonRoom>> getMap() {
        return map;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}

