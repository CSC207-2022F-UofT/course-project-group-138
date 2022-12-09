package save.save_use_case;

import entities.character.Player;
import entities.dungeon.Dungeon;
import entities.dungeon.DungeonRoom;
import settings.Initializer;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class SaveInteractor implements SaveInputBoundry {

    final DsGateway SAVE_DS_GATEWAY;

    final SaveLoadPresenter SAVE_PRESENTER;

    public SaveInteractor(DsGateway dsGateway, SaveLoadPresenter savePresenter) {
        this.SAVE_DS_GATEWAY = dsGateway;
        this.SAVE_PRESENTER = savePresenter;
    }

    @Override
    public SaveResponse performSave(SaveRequest saveRequest) {
        if (SAVE_DS_GATEWAY.fileExists(saveRequest.getFileName())) {
            return SAVE_PRESENTER.saveFailView("File name conflict!");
        }

        LocalDateTime saveTime = LocalDateTime.now();
        Player player = Initializer.getPlayer();
        HashMap<DungeonRoom, List<DungeonRoom>> map = Dungeon.saveDungeon();

        DsRequest dsRequest = new DsRequest(saveRequest.getFileName(), player, map, saveTime);
        SAVE_DS_GATEWAY.save(dsRequest);

        SaveResponse saveResponse = new SaveResponse(saveRequest.getFileName());
        return SAVE_PRESENTER.saveSuccessView(saveResponse);
    }
}
