package save.save_use_case;

public interface SavePresenter {
    SaveResponse saveSuccessView(SaveResponse saveResponse);

    SaveResponse saveFailView(String error);
}
