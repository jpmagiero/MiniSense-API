package Senseup.Minisense.Api.Controller;

import Senseup.Minisense.Api.Model.MeasurementUnitModel;
import Senseup.Minisense.Api.Repository.MeasurementUnitRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="MeasurementUnit API")
@CrossOrigin(origins = "*")
public class MeasurementUnitController  {

    @Autowired
    MeasurementUnitRepository measurementUnitRepository;

    @GetMapping("/measurementUnits")
    @ApiOperation(value = "Retorna uma lista de unidade de medida")
    public List<MeasurementUnitModel> userList() {
        return measurementUnitRepository.findAll();
    }

    @GetMapping("/measurementUnit/{measurementId}")
    @ApiOperation(value = "Retorna uma unidade de medida pelo id")
    public MeasurementUnitModel getById(@PathVariable(value = "measurementId") long measurementId){
        return measurementUnitRepository.findById(measurementId);
    }

    @PostMapping("/measurementUnit")
    @ApiOperation(value = "Adiciona uma nova unidade de medida")
    public MeasurementUnitModel saveMeasurementUnit(@RequestBody MeasurementUnitModel measurementUnitModel){
        return measurementUnitRepository.save(measurementUnitModel);
    }

    @DeleteMapping ("/measurementUnit/{measurementId}")
    @ApiOperation(value = "Deleta uma unidade de medida")
    public void deleteMeasurementUnit(@PathVariable(value = "measurementId") long measurementId){
        measurementUnitRepository.deleteById(measurementId);
    }

    @PutMapping ("/measurementUnit")
    @ApiOperation(value = "Atualiza uma unidade de medida existente")
    public MeasurementUnitModel updateMeasurementUnit(@RequestBody MeasurementUnitModel measurementUnitModel){
        return measurementUnitRepository.save(measurementUnitModel);
    }
}
