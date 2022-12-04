package save.save_use_case;

public interface SaveDsGateway {
    boolean fileExists(String FileName);

    void save(SaveDsRequest saveRequest);
}
