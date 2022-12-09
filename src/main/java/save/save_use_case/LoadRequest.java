package save.save_use_case;
// unfinished
public class LoadRequest {
    private String fileName;

    private boolean quickLoad;


    public LoadRequest(boolean quickLoad) {
        this.fileName = "a";
        this.quickLoad = true;
    }

    public LoadRequest(String fileName) {
        this.fileName = fileName;
        this.quickLoad = false;
    }

    public String getFileName() {
        return fileName;
    }

    void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isQuickLoad() {
        return quickLoad;
    }
}
