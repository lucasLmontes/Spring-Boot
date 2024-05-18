package com.academify.service;

import com.academify.model.entity.EstiloMusical;
import com.academify.model.repository.EstiloMusicalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstiloMusicalService {

    private EstiloMusicalRepository estiloMusicalRepository;

    public EstiloMusicalService(EstiloMusicalRepository estiloMusicalRepository) {
        this.estiloMusicalRepository = estiloMusicalRepository;
    }

    public List<EstiloMusical> findAll(){
        return estiloMusicalRepository.findAll();
    }

    public EstiloMusical findById(Long id) throws Exception {
        Optional<EstiloMusical> estiloMusical = estiloMusicalRepository.findById(id);
        if (!estiloMusical.isPresent()){
            throw new Exception("Estilo musical não encontrado");
        }
        return estiloMusical.get();
    }
}
