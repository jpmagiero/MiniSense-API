package Senseup.Minisense.Api.Repository;

import Senseup.Minisense.Api.Model.SensorDataModel;
import Senseup.Minisense.Api.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SensorDataRepository extends JpaRepository<SensorDataModel, Long>{
    SensorDataModel findById(long id);
}
