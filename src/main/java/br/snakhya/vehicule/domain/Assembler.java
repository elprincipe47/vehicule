package br.snakhya.vehicule.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Assembler implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assemblerName ;

    public Assembler(String assemblerName) {
        this.assemblerName = assemblerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssemblerName() {
        return assemblerName;
    }

    public void setAssemblerName(String assemblerName) {
        this.assemblerName = assemblerName;
    }
}
