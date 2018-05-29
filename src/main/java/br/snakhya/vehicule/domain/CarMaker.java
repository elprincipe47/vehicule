package br.snakhya.vehicule.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CarMaker  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carMaker ;



    public CarMaker(String carMaker) {
        this.carMaker = carMaker;
    }
    public CarMaker() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(String carMaker) {
        this.carMaker = carMaker;
    }
}
