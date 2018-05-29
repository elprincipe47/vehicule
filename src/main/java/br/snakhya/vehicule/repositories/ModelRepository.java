package br.snakhya.vehicule.repositories;

import br.snakhya.vehicule.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model,Long>{
    Optional<Model> findByNameModel(String modelname) ;

}
