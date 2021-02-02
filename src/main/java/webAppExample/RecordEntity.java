package webAppExample;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RecordEntity {
    @Id
    private String key;
    private String value;

    public RecordEntity() {
    }

    public RecordEntity(String key, String value) {
        this.key = key;
        this.value = value;
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

    @Override
    public String toString() {
        return "RecordEntity{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
