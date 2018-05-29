package br.snakhya.vehicule.domain;


import javax.persistence.*;

@Entity
@Inheritance
public abstract  class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String color ;
    private  Integer mileage ;
    private Double motor ;
    private  Model model ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Double getMotor() {
        return motor;
    }

    public void setMotor(Double motor) {
        this.motor = motor;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Vehicule(String color, Integer mileage, Double motor, Model model) {
        this.color = color;
        this.mileage = mileage;
        this.motor = motor;
        this.model = model;
    }
    public Vehicule() {

    }

}
