package Senseup.Minisense.Api.Controller;

import Senseup.Minisense.Api.Model.SensorDataModel;
import Senseup.Minisense.Api.Model.UserModel;
import Senseup.Minisense.Api.Repository.SensorDataRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="SensorData API")
@CrossOrigin(origins = "*")
public class SensorDataController {
    @Autowired
    SensorDataRepository sensorDataRepository;

    @GetMapping("/sensordatas")
    @ApiOperation(value = "Retorna todos os sensores data")
    public List<SensorDataModel> listSensorData(){
        return sensorDataRepository.findAll();
    }

    @GetMapping("/sensordata/{id}")
    @ApiOperation(value = "Retorna um sensor pelo Id")
    public SensorDataModel getById(@PathVariable(value = "id") long id){
        return sensorDataRepository.findById(id);
    }

    @PostMapping("/sensordata")
    @ApiOperation(value = "Adiciona um sensor data")
    public SensorDataModel saveSensorData(@RequestBody SensorDataModel sensorData){
        return sensorDataRepository.save(sensorData);
    }
    @DeleteMapping ("/sensordata/{id}")
    @ApiOperation(value = "Deleta um sensor data")
    public void deleteSensorData(@PathVariable(value = "id") long id){
        sensorDataRepository.deleteById(id);
    }

    @PutMapping ("/sensordata")
    @ApiOperation(value = "Atualiza um sensor data existente")
    public SensorDataModel updateSensorData(@RequestBody SensorDataModel sensorData){
        return sensorDataRepository.save(sensorData);
    }
}
