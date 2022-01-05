package Senseup.Minisense.Api.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "TB_SENSOR_DEVICE")
public class SensorDeviceModel implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String sensorKey;

    @NotNull
    private String label;

    @NotNull
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserModel  user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return sensorKey;
    }

    public void setKey() {
        this.sensorKey = String.valueOf(generateRandomHash());
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) { this.label = label; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    private UUID generateRandomHash() {
        return UUID.randomUUID();
    }
}
