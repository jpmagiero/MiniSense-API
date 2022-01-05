package Senseup.Minisense.Api.Controller;

import Senseup.Minisense.Api.Builder.SensorDeviceBuilder;
import Senseup.Minisense.Api.DTOs.SensorDeviceDTO;
import Senseup.Minisense.Api.DTOs.StreamDTO;
import Senseup.Minisense.Api.Model.DataStreamModel;
import Senseup.Minisense.Api.Model.SensorDeviceModel;
import Senseup.Minisense.Api.Model.UserModel;
import Senseup.Minisense.Api.Repository.DataStreamRepository;
import Senseup.Minisense.Api.Repository.SensorDeviceRepository;
import Senseup.Minisense.Api.Repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="SensorDevice API")
@CrossOrigin(origins = "*")
public class SensorDeviceController {

    @Autowired
    SensorDeviceRepository sensorDeviceRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DataStreamRepository dataStreamRepository;

    @GetMapping("/sensordevices")
    @ApiOperation(value = "Retorna uma lista de sensores")
    public List<SensorDeviceBuilder> SensorDeviceList() {
        List<SensorDeviceModel> sensors = sensorDeviceRepository.findAll();
        List<SensorDeviceBuilder> sensorDevices = new ArrayList<SensorDeviceBuilder>();
        List<StreamDTO> streams = new ArrayList<StreamDTO>();

        for (SensorDeviceModel sensor : sensors) {
            List<DataStreamModel> dataStreams = dataStreamRepository.retrieveDataStreamsBySensorId(sensor.getId());

            sensorDevices.add(new SensorDeviceBuilder(sensor, dataStreams));
        }

        return sensorDevices;
    }

    @GetMapping("/sensordevice/user/{userId}")
    @ApiOperation(value = "Retorna um sensor pelo UserId")
    public List<SensorDeviceModel> getSensorDeviceByUserId(@PathVariable(value = "userId") long userId){
        return sensorDeviceRepository.retrieveSensorDevicesByUserId(userId);
    }

    @GetMapping("/sensordevice/{id}")
    @ApiOperation(value = "Retorna um sensor pelo Id")
    public SensorDeviceBuilder getSensorDeviceById(@PathVariable(value = "id") long id) {
        SensorDeviceModel sensorDevice = sensorDeviceRepository.findById(id);
        List<DataStreamModel> dataStreams = dataStreamRepository.retrieveDataStreamsBySensorId(sensorDevice.getId());

        return new SensorDeviceBuilder(sensorDevice, dataStreams);
    }

    @PostMapping("/sensordevice")
    @ApiOperation(value = "Adiciona um novo sensor")
    public SensorDeviceModel saveSensorDevice(@RequestBody SensorDeviceDTO sensorDeviceDTO){
        UserModel user = userRepository.findById(sensorDeviceDTO.userId);
        SensorDeviceModel sensorDevice = new SensorDeviceModel();

        sensorDevice.setLabel(sensorDeviceDTO.label);
        sensorDevice.setDescription(sensorDeviceDTO.description);
        sensorDevice.setKey();
        sensorDevice.setUser(user);

        return sensorDeviceRepository.save(sensorDevice);
    }

    @PutMapping("/sensordevice")
    @ApiOperation(value = "Atualiza um cadastro de sensor existente")
    public SensorDeviceModel updateSensorDevice(@RequestBody SensorDeviceDTO sensorDeviceDTO){
        UserModel user = userRepository.findById(sensorDeviceDTO.userId);
        SensorDeviceModel sensorDevice = sensorDeviceRepository.findById(sensorDeviceDTO.id);

        sensorDevice.setLabel(sensorDeviceDTO.label);
        sensorDevice.setDescription(sensorDeviceDTO.description);
        sensorDevice.setKey();
        sensorDevice.setUser(user);

        return sensorDeviceRepository.save(sensorDevice);
    }

    @DeleteMapping ("/sensordevice/{id}")
    @ApiOperation(value = "Deleta um sensor pelo Id")
    public void deleteSensorDevice(@PathVariable(value = "id") long id){
        sensorDeviceRepository.deleteById(id);
    }
}
