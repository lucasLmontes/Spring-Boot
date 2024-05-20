package com.academify.service;

import com.academify.model.entity.EstiloMusical;
import com.academify.model.repository.EstiloMusicalRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstiloMusicalService {

    private final EstiloMusicalRepository estiloMusicalRepository;

    public EstiloMusicalService(EstiloMusicalRepository estiloMusicalRepository) {
        this.estiloMusicalRepository = estiloMusicalRepository;
    }

    public List<EstiloMusical> findAll(){
        return estiloMusicalRepository.findAll();
    }

    public EstiloMusical findById(Long id) throws Exception{
        Optional<EstiloMusical> estiloMusical = estiloMusicalRepository.findById(id);
        if (!estiloMusical.isPresent()){
            throw new Exception("Estilo musical não encontrado.");
        }
        return estiloMusical.get();
    }

    public EstiloMusical save(EstiloMusical estiloMusical) throws Exception{
        if (!estiloMusical.getNome().matches("[A-Za-z+]")){
            throw new Exception("O nome do estilo musical deve possuir apenas letras.");
        }

        if (estiloMusical.getNome() == null || estiloMusical.getNome().length() < 3){
            throw new Exception("O nome do estilo musical deve ter pelo menos três caracteres.");
        }

        EstiloMusical estiloCriado = estiloMusicalRepository.findByNome(estiloMusical.getNome());
        if (estiloCriado != null && !estiloCriado.getId().equals(estiloMusical.getId())){
            throw new Exception("Já existe um estilo musical com o mesmo nome.");
        }

        if (!estiloMusical.getFiguraImportante().matches("[A-Za-z+]")){
            throw new Exception("A figura importante do estilo musical deve possuir apenas letras.");
        }

        if (estiloMusical.getFiguraImportante() == null){
            throw new Exception("É obrigatório haver figura importante.");
        }

        if (!estiloMusical.getInstrumentoPrincipal().matches("[A-Za-z+]")){
            throw new Exception("O instrumento principal do estilo musical deve possuir apenas letras.");
        }

        if (estiloMusical.getInstrumentoPrincipal() == null){
            throw new Exception("Instrumento principal é obrigatório.");
        }

        if (estiloMusical.getPaisOrigem() == null || estiloMusical.getPaisOrigem().length() < 3){
            throw new Exception("País de origem de um estilo musical deve possuir pelo menos três caracteres.");
        }

        if (!estiloMusical.getPaisOrigem().matches("[A-Za-z+]")){
            throw new Exception("O país de origem de um estilo musical deve possuir apenas letras.");
        }

        if (estiloMusical.getAnoSurgimento() != null){
            Date dataAtual = new Date();
            if (estiloMusical.getAnoSurgimento().after(dataAtual)){
                throw new Exception("Ano de surgimento deve ser uma data válida.");
            }
        }

        return estiloMusicalRepository.save(estiloMusical);
    }

    public EstiloMusical delete(Long id) throws Exception{
        Optional<EstiloMusical> estiloMusical = estiloMusicalRepository.findById(id);
        if (!estiloMusical.isPresent()){
            throw new Exception("Estilo musical não encontrado");
        }
        estiloMusicalRepository.delete(estiloMusical.get());
        return estiloMusical.get();
    }

    public Long count(){
        return estiloMusicalRepository.count();
    }
}
