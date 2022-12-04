package save.save_use_case;

import entities.character.Player;

// neeed to import the Player Class and inventory class

public class SaveRequest {
    private String fileName;

    private Player player;

    // might need an attribute for dungeons

    public SaveRequest(String fileName, Player player) {
        this.fileName = fileName;
        this.player = player;
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
}

