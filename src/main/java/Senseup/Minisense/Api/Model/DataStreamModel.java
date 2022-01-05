package Senseup.Minisense.Api.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_DATA_STREAM")
public class DataStreamModel implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String streamKey;

    @NotNull
    private String label;

    @NotNull
    private Boolean enabled;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id", nullable = false)
    private SensorDeviceModel sensor;

    @ManyToOne
    @JoinColumn(name = "sensor_data_id", referencedColumnName = "id", nullable = false)
    private SensorDataModel sensorData;

    @ManyToOne
    @JoinColumn(name = "measurement_id", referencedColumnName = "id", nullable = false)
    private MeasurementUnitModel measurementUnit;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SensorDeviceModel getSensor() {
        return sensor;
    }

    public void setSensor(SensorDeviceModel sensor) {
        this.sensor = sensor;
    }

    public String getStreamKey() {
        return streamKey;
    }

    public void setStreamKey() {
        this.streamKey = String.valueOf(generateRandomHash());
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setStreamKey(String streamKey) {
        this.streamKey = streamKey;
    }

    public SensorDataModel getSensorData() {
        return sensorData;
    }

    public void setSensorData(SensorDataModel sensorData) {
        this.sensorData = sensorData;
    }

    public MeasurementUnitModel getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnitModel measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    private UUID generateRandomHash() {
        return UUID.randomUUID();
    }

}
