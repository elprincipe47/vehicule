package br.snakhya.vehicule.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameModel ;



    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicule vehicule ;


    public Model(String nameModel) {
        this.nameModel = nameModel;
    }
    public Model() {

    }

    public Long getId() {
        return id;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
