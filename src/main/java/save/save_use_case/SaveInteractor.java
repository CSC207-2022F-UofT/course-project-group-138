package save.save_use_case;

import entities.character.Player;


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

        // need modification since class SaveDsRequest change
        SaveDsRequest saveDsRequest = new SaveDsRequest(saveRequest.getFileName(),
                saveRequest.getPlayer(),
                saveTime);
        SAVE_DS_GATEWAY.save(saveDsRequest);

        SaveResponse saveResponse = new SaveResponse(saveRequest.getFileName());
        return SAVE_PRESENTER.saveSuccessView(saveResponse);
    }
}
