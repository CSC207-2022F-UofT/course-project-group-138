package save.save_use_case;

public class SaveRequest {
    private String fileName;

    public SaveRequest(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}

