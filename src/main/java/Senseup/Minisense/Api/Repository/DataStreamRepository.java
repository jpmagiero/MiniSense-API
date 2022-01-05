package Senseup.Minisense.Api.Repository;

import Senseup.Minisense.Api.Model.DataStreamModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public interface DataStreamRepository extends JpaRepository<DataStreamModel, Long> {

    DataStreamModel findById(long id);

    default List<DataStreamModel> retrieveDataStreamsBySensorId(long sensorId) {
        List<DataStreamModel> dataStreams = this.findAll();

        return dataStreams.stream()
                .filter(x -> x.getSensor().getId() == sensorId).collect(Collectors.toList());
    }
}
