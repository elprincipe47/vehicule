package br.snakhya.vehicule.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Car extends Vehicule implements Serializable {

    @ManyToOne
    private CarMaker carMaker ;

    public Car(Assembler assembler,String color, Integer mileage, Double motor, Model model,CarMaker carMaker) {
        super( color, mileage, motor,model);
        this.carMaker = carMaker;
    }
    public Car(){}
    public CarMaker getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(CarMaker carMaker) {
        this.carMaker = carMaker;
    }
}
