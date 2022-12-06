package save.save_use_case;

public interface DsGateway {
    boolean fileExists(String FileName);

    void save(DsRequest dsRequest);

    DsRequest load(LoadRequest loadRequest);

    //DsRequest quickLoad();

    boolean isEmptyDatabase();
}
