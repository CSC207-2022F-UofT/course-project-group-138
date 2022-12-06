package save.save_use_case;

import entities.character.Player;

import java.time.LocalDateTime;

public class SaveDsRequest {
    private String fileName;

    private Player player;

    /*private String playerCoins;

    private String playerWeaponAttack;

    private String playerWeaponPrice;

    private String playerArmorHp;

    private String playerArmorPrice;

    private String playerHp;

    private String playerNumOfEnenmySlayed;

    private String playerX;

    private String playerY;*/

    private final LocalDateTime creationTime;

    public SaveDsRequest(String fileName, Player player, LocalDateTime creationTime) {
        this.fileName = fileName;
        this.player = player;
        this.creationTime = creationTime;
    }

/*    public SaveDsRequest(String fileName, String playerCoins, String playerWeaponAttack, String playerWeaponPrice,
                         String playerArmorHp, String playerArmorPrice, String playerHp, String playerNumOfEnenmySlayed,
                         LocalDateTime creationTime, String playerX, String playerY) {
        this.fileName = fileName;
        this.playerCoins = playerCoins;
        this.playerWeaponAttack = playerWeaponAttack;
        this.playerWeaponPrice = playerWeaponPrice;
        this.playerArmorHp = playerArmorHp;
        this.playerArmorPrice = playerArmorPrice;
        this.playerHp = playerHp;
        this.playerNumOfEnenmySlayed = playerNumOfEnenmySlayed;
        this.creationTime = creationTime;
        this.playerX = playerX
        this.playerY = playerY;

*//*        PlayerCreator creator = new PlayerCreator();
        this.fileName = fileName;
        this.player = creator.create(playerCoins,
                playerWeaponAttack,
                playerWeaponPrice,
                playerArmorHp,
                playerArmorPrice,
                playerHp,
                playerNumOfEnenmySlayed);
        this.creationTime = creationTime;*//*
    }*/
    public String getFileName() {
        return fileName;
    }

    void setFileName(String filename) {
        this.fileName = filename;
    }

    public int getPlayerCoins() {
        return player.getCoins();
    }

    public int getPlayerWeaponAttack() {
        return player.getAttackPower();
    }

//    public int getPlayerWeaponPrice() {
//        return player.getInventory().getWeapon().getPrice();
//    }

    public int getPlayerArmorHp() {
        return player.getArmorDurability();
    }

//    public int getPlayerArmorPrice() {
//        return player.getInventory().getArmor().getPrice();
//    }

    public int getPlayerKills() {
        return player.getKills();
    }

    public int getPlayerHp() {
        return player.getCurrentHealth();
    }

    public int getPlayerX() {
        return player.getx();
    }

    public int getPlayerY() { return player.gety(); }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}

