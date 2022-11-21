package save_use_case;

import inventory.Armor;
import inventory.Inventory;
import inventory.Weapon;
import temporary_classes.Player;

import java.time.LocalDateTime;

public class SaveInteractor implements SaveInputBoundry {

    final SaveDsGateway SAVE_DS_GATEWAY;

    final SavePresenter SAVE_PRESENTER;

    final Player PLAYER;

    public SaveInteractor(SaveDsGateway saveDsGateway, SavePresenter savePresenter, Player player) {
        this.SAVE_DS_GATEWAY = saveDsGateway;
        this.SAVE_PRESENTER = savePresenter;
        this.PLAYER = player;
    }

    @Override
    public SaveResponse performSave(SaveRequest saveRequest) {
        if (SAVE_DS_GATEWAY.fileExists(saveRequest.getFileName())) {
            return SAVE_PRESENTER.saveFailView("File name conflict!");
        }

        LocalDateTime saveTime = LocalDateTime.now();
        Player player = saveRequest.getPlayer();
        Inventory playerInv = player.getInventory();
        Armor playerArmor = playerInv.getArmor();
        Weapon playerWeapon = playerInv.getWeapon();

        String playerCoins = String.valueOf(playerInv.getCoins());
        String playerWeaponAttack = String.valueOf(playerWeapon.getAttack());
        String playerWeaponPrice = String.valueOf(playerWeapon.getPrice());
        String playerArmorHp = String.valueOf(playerArmor.getHp());
        String playerArmorPrice = String.valueOf(playerArmor.getPrice());
        String playerHp = String.valueOf(player.getHP());
        String playerNumOfEnenmySlayed = String.valueOf(player.getNumOfEnemySlain());

        // need modification since class SaveDsRequest change
        SaveDsRequest saveDsRequest = new SaveDsRequest(saveRequest.getFileName(),
                playerCoins,
                playerWeaponAttack,
                playerWeaponPrice,
                playerArmorHp,
                playerArmorPrice,
                playerHp,
                playerNumOfEnenmySlayed,
                saveTime);
        SAVE_DS_GATEWAY.save(saveDsRequest);

        SaveResponse saveResponse = new SaveResponse(saveRequest.getFileName());
        return SAVE_PRESENTER.saveSuccessView(saveResponse);
    }
}
