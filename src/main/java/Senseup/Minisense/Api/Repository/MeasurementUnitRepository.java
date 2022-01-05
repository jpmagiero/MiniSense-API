package Senseup.Minisense.Api.Repository;

import Senseup.Minisense.Api.Model.MeasurementUnitModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnitModel, Long> {
    MeasurementUnitModel findById(long MeasurementId);
}
