package webAppExample;

public class RecordsStatsDto {
    private long recordsCount;
    private long notNullRecordsCount;

    public RecordsStatsDto(long recordsCount, long notNullRecordsCount) {
        this.recordsCount = recordsCount;
        this.notNullRecordsCount = notNullRecordsCount;
    }

    public RecordsStatsDto() {
    }

    public long getRecordsCount() {
        return recordsCount;
    }

    public void setRecordsCount(long recordsCount) {
        this.recordsCount = recordsCount;
    }

    public long getNotNullRecordsCount() {
        return notNullRecordsCount;
    }

    public void setNotNullRecordsCount(long notNullRecordsCount) {
        this.notNullRecordsCount = notNullRecordsCount;
    }
}
