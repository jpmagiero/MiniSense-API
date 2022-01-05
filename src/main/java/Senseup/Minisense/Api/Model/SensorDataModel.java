package Senseup.Minisense.Api.Model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_SENSOR_DATA")
public class SensorDataModel implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String timestamp;

    @NotNull
    private double value;

    public long getId() {
        return id;
    }

    public void setSensorDataId(long id) {
        this.id = id;
    }

    public String getTimesTamp() {
        return timestamp;
    }

    public void setTimesTamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
