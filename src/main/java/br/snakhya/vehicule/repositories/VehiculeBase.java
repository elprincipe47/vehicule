package br.snakhya.vehicule.repositories;


import br.snakhya.vehicule.domain.Model;
import br.snakhya.vehicule.domain.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface VehiculeBase <T extends Vehicule>
        extends JpaRepository<T, Long> {
    public List<T> findByColor(String color);
    public List<T> findByMileage(Integer mileage);
    public List<T> findByMotor(Double motor);
    public List<T> findByModel(Model model);


}
