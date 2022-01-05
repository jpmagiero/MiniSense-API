package Senseup.Minisense.Api.Controller;

import Senseup.Minisense.Api.DTOs.DataStreamDTO;
import Senseup.Minisense.Api.Model.*;
import Senseup.Minisense.Api.Repository.DataStreamRepository;
import Senseup.Minisense.Api.Repository.MeasurementUnitRepository;
import Senseup.Minisense.Api.Repository.SensorDataRepository;
import Senseup.Minisense.Api.Repository.SensorDeviceRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="DataStream API")
@CrossOrigin(origins = "*")
public class DataStreamController {

    @Autowired
    DataStreamRepository dataStreamRepository;

    @Autowired
    SensorDeviceRepository sensorDeviceRepository;

    @Autowired
    SensorDataRepository sensorDataRepository;

    @Autowired
    MeasurementUnitRepository measurementUnitRepository;

    @GetMapping("/datastreams")
    @ApiOperation(value = "Retorna uma lista de Streams")
    public List<DataStreamModel> DataStreamList() {
        return dataStreamRepository.findAll();
    }

    @GetMapping("/datastream/sensor/{sensorId}")
    @ApiOperation(value = "Retorna um data stream pelo sensorId")
    public List<DataStreamModel> getDataStreamBySensorId(@PathVariable(value = "sensorId") long sensorId) {
        return dataStreamRepository.retrieveDataStreamsBySensorId(sensorId);
    }

    @GetMapping("/datastream/stream/{id}")
    @ApiOperation(value = "Retorna um data stream pelo Id")
    public DataStreamModel getDataStreamById(@PathVariable(value = "id") long id) {
        return dataStreamRepository.findById(id);
    }

    @PostMapping("/datastream")
    @ApiOperation(value = "Adiciona um data stream")
    public DataStreamModel saveDataStream(@RequestBody DataStreamDTO dataStreamDTO) {
        SensorDeviceModel sensor = sensorDeviceRepository.findById(dataStreamDTO.sensorId);
        SensorDataModel data = sensorDataRepository.findById(dataStreamDTO.sensorDataId);
        MeasurementUnitModel unit = measurementUnitRepository.findById(dataStreamDTO.measurementUnitId);
        DataStreamModel dataStream = new DataStreamModel();

        dataStream.setEnabled(dataStreamDTO.enabled);
        dataStream.setLabel(dataStreamDTO.label);
        dataStream.setStreamKey();
        dataStream.setSensor(sensor);
        dataStream.setSensorData(data);
        dataStream.setMeasurementUnit(unit);

        return dataStreamRepository.save(dataStream);
    }

    @DeleteMapping ("/datastream/{id}")
    @ApiOperation(value = "Deleta um data stream")
    public void deleteDataStream(@PathVariable(value = "id") long id){
        dataStreamRepository.deleteById(id);
    }

    @PutMapping ("/datastream")
    @ApiOperation(value = "Atualiza um data stream existente")
    public DataStreamModel updateDataStream(@RequestBody DataStreamModel dataStreamModel){
        return dataStreamRepository.save(dataStreamModel);
    }
}
