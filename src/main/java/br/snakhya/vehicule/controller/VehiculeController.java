package br.snakhya.vehicule.controller;


import br.snakhya.vehicule.domain.*;
import br.snakhya.vehicule.repositories.ModelRepository;
import br.snakhya.vehicule.repositories.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/vehicules")
public class VehiculeController {

    @Autowired
    private VehiculeRepository vehiculeRepository ;

    @Autowired
    private ModelRepository modelRepository ;

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})

    @ResponseBody
    public List<Vehicule> getAllVehicules() {
        return this.vehiculeRepository.findAll();
    }

   /// filter  vehicules by colors
    @RequestMapping(value = "/color/{colorName}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})

    @ResponseBody
    public List<Vehicule> getAllVehiculesbycolor(@PathVariable String colorName) {
        return this.vehiculeRepository.findByColor(colorName);
    }

    /// filter  vehicules by mileage
    @RequestMapping(value = "/mileage/{mileage}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})

    @ResponseBody
    public List<Vehicule> getAllVehiculesMileage(@PathVariable Integer mileage) {
        return this.vehiculeRepository.findByMileage(mileage);
    }

    /// filter  vehicules by motor
    @RequestMapping(value = "/motor/{motorvar}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})

    @ResponseBody
    public List<Vehicule> getAllVehiculesMileage(@PathVariable Double motorvar) {
        return this.vehiculeRepository.findByMotor(motorvar);
    }

    /// filter  vehicules by model
    @RequestMapping(value = "/model/{modelname}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})

    @ResponseBody
    public List<Vehicule> getAllVehiculesMileage(@PathVariable String modelname) {
        Model model = this.modelRepository.findByNameModel(modelname).get();
        return this.vehiculeRepository.findByModel(model);
    }


    //  add car
    @PostMapping("/car")
    public Vehicule createCar( @RequestBody Car vehicule) {
        return this.vehiculeRepository.save(vehicule) ;
    }
// add moto
    @PostMapping("/moto")
    public Vehicule createCar( @RequestBody Moto vehicule) {
        return this.vehiculeRepository.save(vehicule) ;
    }

    @PutMapping("/{vehiculeid}")
    public Vehicule updateAssembler(@PathVariable Long vehiculeid, @Valid @RequestBody Vehicule vehicule) throws  Exception{
        Vehicule vehicule1 =  this.vehiculeRepository.findById(vehiculeid).get() ;
        vehicule1.setColor(vehicule.getColor());
        vehicule1.setMileage(vehicule.getMileage());
        vehicule1.setModel(vehicule.getModel());
        vehicule1.setMotor(vehicule.getMotor());
        this.vehiculeRepository.save(vehicule1);
        return vehicule1;
    }

    @DeleteMapping("/{vehiculeid}")
    public String deleteAssembler(@PathVariable(value = "vehiculeid") Long id) {
        Vehicule vehicule = vehiculeRepository.findById(id).get();
        Long name = vehicule.getId();
        vehiculeRepository.delete(vehicule);
        return "the vehicule with id "+ name.toString() +" is deleted ";
    }
}
