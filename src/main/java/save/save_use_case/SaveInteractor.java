package save.save_use_case;

import java.time.LocalDateTime;

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

        // need modification since class DsRequest change
        DsRequest dsRequest = new DsRequest(saveRequest.getFileName(),
                saveRequest.getPlayer(),
                saveRequest.getDungeon(),
                saveTime);
        SAVE_DS_GATEWAY.save(dsRequest);

        SaveResponse saveResponse = new SaveResponse(saveRequest.getFileName());
        return SAVE_PRESENTER.saveSuccessView(saveResponse);
    }
}
