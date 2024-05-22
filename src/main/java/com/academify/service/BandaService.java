package com.academify.service;

import com.academify.model.entity.Banda;
import com.academify.model.repository.BandaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BandaService {
    private final BandaRepository bandaRepository;

    public BandaService(BandaRepository bandaRepository) {
        this.bandaRepository = bandaRepository;
    }

    public List<Banda> findAll(){
        return bandaRepository.findAll();
    }

    public Banda findById(Long id) throws Exception{
        Optional<Banda> banda = bandaRepository.findById(id);
        if (!banda.isPresent()){
            throw new Exception("Banda não encontrada.");
        }
        return banda.get();
    }

    public Banda save(Banda banda) throws Exception{
        if (banda.getNome() == null || banda.getNome().length() < 3){
            throw new Exception("O nome deve possuir pelo menos três caracteres.");
        }

        Banda bandaCriada = bandaRepository.findByNome(banda.getNome());
        if (bandaCriada != null && !bandaCriada.getId().equals(banda.getId())){
            throw new Exception("Já existe uma banda com o mesmo nome.");
        }

        if (banda.getQuantidadeMusicas() < 1 || banda.getQuantidadeMusicas() > 9999){
            throw new Exception("A quantidade de músicas deve estar no intervalo entre 1 9999.");
        }

        if (banda.getDataCriacao() == null){
            throw new Exception("A banda deve possuir uma data de criação.");
        }
        else{
            Date dataAtual = new Date();
            if (banda.getDataCriacao().after(dataAtual)){
                throw new Exception("A data de criação de uma banda deve ser menor ou igual a data atual.");
            }
        }

        if (banda.getDataDissolucao() != null){
            Date dataAtual = new Date();
            if (banda.getDataDissolucao().before(dataAtual)){
                banda.setAtividadeBanda(false);
            }
            else{
                if (banda.getDataDissolucao().after(dataAtual)){
                    throw new Exception("A data de dissolução de uma banda deve ser menor ou igual a data atual.");
                }
            }
        }
        else{
            banda.setAtividadeBanda(true);
        }

        if (banda.getPaisOrigem() == null || banda.getPaisOrigem().length() < 3){
            throw new Exception("País de origem de uma banda deve possuir pelo menos três caracteres.");
        }

        Banda registro = bandaRepository.findByNome(banda.getRegistroBanda());
        if (registro != null && !bandaCriada.getId().equals(banda.getId())){
            throw new Exception("Já existe uma banda com esse registro.");
        }

        if (banda.getRegistroBanda().length() != 5){
            throw new Exception("O registro de uma banda deve conter cinco caracteres.");
        }

        if (!banda.getRegistroBanda().matches("^[A-Z]{2}[0-9]{3}$")){
            throw new Exception("O registro da banda deve ter os dois primeiros caracteres sendo letras e os três últimos sendo números.");
        }

        if (banda.getQuantidadeIntegrantes() < 3){
            throw new Exception("A banda deve ter pelo menos três integrantes.");
        }

        if (banda.getSingleDestaque() == null){
            throw new Exception("Single destaque é obrigatório.");
        }

        if (banda.getAlbumDestaque() == null){
            throw new Exception("Álbum destaque é obrigatório.");
        }

        return bandaRepository.save(banda);
    }

    public Banda delete(Long id) throws Exception{
        Optional<Banda> banda = bandaRepository.findById(id);
        if (!banda.isPresent()){
            throw new Exception("Banda não encontrada.");
        }

        bandaRepository.delete(banda.get());
        return banda.get();
    }

    public Long count(){
        return bandaRepository.count();
    }
}
