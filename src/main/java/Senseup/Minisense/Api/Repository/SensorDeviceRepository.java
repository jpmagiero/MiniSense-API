package Senseup.Minisense.Api.Repository;

import Senseup.Minisense.Api.Model.SensorDeviceModel;
import Senseup.Minisense.Api.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public interface SensorDeviceRepository extends JpaRepository<SensorDeviceModel, Long> {
    SensorDeviceModel findById(long id);

    default List<SensorDeviceModel> retrieveSensorDevicesByUserId(long userId) {
       List<SensorDeviceModel> sensorDevices = this.findAll();

       return sensorDevices.stream()
               .filter(x -> x.getUser().getId() == userId).collect(Collectors.toList());
    }
}
