package Senseup.Minisense.Api.DTOs;

public class StreamDTO {
    public StreamDTO() {}

    public StreamDTO(long id, String key, String label, long unitId, long deviceId, long measurementCount) {
        this.id = id;
        this.key = key;
        this.label = label;
        this.unitId = unitId;
        this.deviceId = deviceId;
        this.measurementCount = measurementCount;
    }

    public long id;
    public String key;
    public String label;
    public long unitId;
    public long deviceId;
    public long measurementCount;
}