package save.save_screen;

import save.save_use_case.LoadResponse;
import save.save_use_case.SaveLoadPresenter;
import save.save_use_case.SaveResponse;

public class UpdateResponse implements SaveLoadPresenter {

    @Override
    public SaveResponse saveSuccessView(SaveResponse saveResponse) {
        return saveResponse;
    }

    public SaveResponse saveFailView(String error) {
        throw new RuntimeException(error);
    }

    public LoadResponse loadSuccessView(LoadResponse loadResponse) {
        return loadResponse;
    }

    public LoadResponse loadFailView(String error) {
        throw new RuntimeException(error);
    }
}
