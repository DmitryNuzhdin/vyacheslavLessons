package webAppExample;

public class RecordDto {
    private String key;
    private String value;

    public RecordDto(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public RecordDto() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
