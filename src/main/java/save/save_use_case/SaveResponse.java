package save.save_use_case;

public class SaveResponse {

    private String fileName;

    public SaveResponse(String fileName) {
        this.fileName = fileName;
    }

    public String getFilename() {
        return fileName;
    }

    void setFilename(String fileName) {
        this.fileName = fileName;
    }
}
