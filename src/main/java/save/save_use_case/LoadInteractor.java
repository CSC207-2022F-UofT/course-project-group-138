package save.save_use_case;

public class LoadInteractor implements LoadInputBoundary {

    final DsGateway SAVE_DS_GATEWAY;

    final SaveLoadPresenter SAVE_PRESENTER;

    public LoadInteractor(DsGateway dsGateway, SaveLoadPresenter saveLoadPresenter) {
        this.SAVE_DS_GATEWAY = dsGateway;
        this.SAVE_PRESENTER = saveLoadPresenter;
    }
    public LoadResponse performLoad(LoadRequest loadRequest) {
        if (SAVE_DS_GATEWAY.fileExists(loadRequest.getFileName())) {
            return SAVE_PRESENTER.loadFailView("File name does not exist!");
        }

        DsRequest loadedFile = SAVE_DS_GATEWAY.load(loadRequest);

        LoadResponse loadResponse = new LoadResponse(loadedFile.getFileName(), loadedFile.getPlayer(), loadedFile.getDungeon());
        return SAVE_PRESENTER.loadSuccessView(loadResponse);
    }

    public LoadResponse performQuickLoad(LoadRequest loadRequest) {
        if (SAVE_DS_GATEWAY.isEmptyDatabase()) {
            return SAVE_PRESENTER.loadFailView("You have not saved any game yet!");
        }

        DsRequest loadedFile = SAVE_DS_GATEWAY.load(loadRequest);
        LoadResponse loadResponse = new LoadResponse(loadedFile.getFileName(), loadedFile.getPlayer(), loadedFile.getDungeon());
        return SAVE_PRESENTER.loadSuccessView(loadResponse);
    }
}
