package save.save_use_case;

public interface SaveInputBoundry {
    SaveResponse performSave(SaveRequest saveRequest);

    //public MenuResponseModel performLoad(LoadRequest loadRequest);
}
