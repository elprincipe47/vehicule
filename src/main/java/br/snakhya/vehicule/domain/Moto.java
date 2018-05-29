package br.snakhya.vehicule.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
@Entity
public class Moto extends Vehicule implements Serializable {


    @ManyToOne
    private  Assembler assembler ;

    public Moto(Assembler assembler,String color, Integer mileage, Double motor, Model model) {
        super( color, mileage, motor,model);
        this.assembler = assembler;
    }
    public Moto(){}

    public Assembler getAssembler() {
        return assembler;
    }

    public void setAssembler(Assembler assembler) {
        this.assembler = assembler;
    }
}
