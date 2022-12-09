package save.save_use_case;

public interface SaveLoadPresenter {
    SaveResponse saveSuccessView(SaveResponse saveResponse);

    SaveResponse saveFailView(String error);

    LoadResponse loadSuccessView(LoadResponse loadResponse);

    LoadResponse loadFailView(String error);
}
