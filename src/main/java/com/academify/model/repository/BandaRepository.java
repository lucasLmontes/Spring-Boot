package com.academify.model.repository;

import com.academify.model.entity.Banda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandaRepository extends JpaRepository<Banda, Long> {
    Banda findByNome(String nome);
    Banda findByRegistroBanda(String registroBanda);
}
