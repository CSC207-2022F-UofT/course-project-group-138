package save_use_case;
// unfinished
public class LoadRequest {
    private String fileName;

    private String sortMethod;

    public LoadRequest(String fileName, String sortMethod) {
        this.fileName = fileName;
        this.sortMethod = sortMethod;
    }

    public String getFileName() {
        return fileName;
    }

    void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSortMethod() {
        return sortMethod;
    }

    void setSortMethod(String sortMethod) {
        this.sortMethod = sortMethod;
    }
}
