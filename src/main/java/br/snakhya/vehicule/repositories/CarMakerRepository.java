package br.snakhya.vehicule.repositories;

import br.snakhya.vehicule.domain.CarMaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarMakerRepository extends JpaRepository<CarMaker,Long> {
    Optional<CarMaker> findById(Long carMakerId) ;
}
