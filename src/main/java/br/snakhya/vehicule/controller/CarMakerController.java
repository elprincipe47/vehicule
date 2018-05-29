package br.snakhya.vehicule.controller;

import br.snakhya.vehicule.domain.CarMaker;
import br.snakhya.vehicule.repositories.CarMakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/carmakers")
public class CarMakerController {

        @Autowired
        private CarMakerRepository carMakerRepository;

        @RequestMapping(value = "",
                method = RequestMethod.GET,
                produces = {"application/json", "application/xml"})

        @ResponseBody
        public List<CarMaker> getAllCarMkers() {
            return this.carMakerRepository.findAll();
        }


        @PostMapping("")
        public CarMaker createCarMaker( @RequestBody CarMaker carMaker) {
            return this.carMakerRepository.save(carMaker) ;
        }

        @PutMapping("/{carMakerId}")
        public CarMaker updateCarMaker(@PathVariable Long carMakerId, @Valid @RequestBody CarMaker carMakerupd) throws  Exception{
            CarMaker carMaker =  this.carMakerRepository.findById(carMakerId).get() ;
            carMaker.setCarMaker(carMakerupd.getCarMaker());

           this.carMakerRepository.save(carMaker);
            return carMaker;
        }

        @DeleteMapping("/{carMakerId}")
        public String deleteCarMaker(@PathVariable(value = "carMakerId") Long id) {
            CarMaker carMaker = carMakerRepository.findById(id).get();
            String name = carMaker.getCarMaker();
            carMakerRepository.delete(carMaker);
            return "the carMaker "+name +" is deleted ";
        }
    }
