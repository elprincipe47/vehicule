package br.snakhya.vehicule.repositories;

import br.snakhya.vehicule.domain.Assembler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssemblerRepository extends JpaRepository<Assembler,Long> {
}
