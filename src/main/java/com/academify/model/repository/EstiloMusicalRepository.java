package com.academify.model.repository;

import com.academify.model.entity.EstiloMusical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstiloMusicalRepository extends JpaRepository<EstiloMusical, Long> {
    EstiloMusical findByNome(String nome);
}
