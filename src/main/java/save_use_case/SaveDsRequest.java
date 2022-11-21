package save_use_case;

import entites.PlayerCreator;

import java.time.LocalDateTime;

public class SaveDsRequest {
    private String fileName;

    private String playerCoins;

    private String playerWeaponAttack;

    private String playerWeaponPrice;

    private String playerArmorHp;

    private String playerArmorPrice;

    private String playerHp;

    private String playerNumOfEnenmySlayed;

    private final LocalDateTime creationTime;

    public SaveDsRequest(String fileName, String playerCoins, String playerWeaponAttack, String playerWeaponPrice,
                         String playerArmorHp, String playerArmorPrice, String playerHp, String playerNumOfEnenmySlayed,
                         LocalDateTime creationTime) {
        this.fileName = fileName;
        this.playerCoins = playerCoins;
        this.playerWeaponAttack = playerWeaponAttack;
        this.playerWeaponPrice = playerWeaponPrice;
        this.playerArmorHp = playerArmorHp;
        this.playerArmorPrice = playerArmorPrice;
        this.playerHp = playerHp;
        this.playerNumOfEnenmySlayed = playerNumOfEnenmySlayed;
        this.creationTime = creationTime;

/*        PlayerCreator creator = new PlayerCreator();
        this.fileName = fileName;
        this.player = creator.create(playerCoins,
                playerWeaponAttack,
                playerWeaponPrice,
                playerArmorHp,
                playerArmorPrice,
                playerHp,
                playerNumOfEnenmySlayed);
        this.creationTime = creationTime;*/
    }
    public String getFileName() {
        return fileName;
    }

    void setFileName(String filename) {
        this.fileName = filename;
    }

    public String getPlayerCoins() {
        return playerCoins;
    }

    public String getPlayerWeaponAttack() {
        return playerWeaponAttack;
    }

    public String getPlayerWeaponPrice() {
        return playerWeaponPrice;
    }

    public String getPlayerArmorHp() {
        return playerArmorHp;
    }

    public String getPlayerArmorPrice() {
        return playerArmorPrice;
    }

    public String getPlayerNumOfEnenmySlayed() {
        return playerNumOfEnenmySlayed;
    }

    public String getPlayerHp() {
        return playerHp;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}

