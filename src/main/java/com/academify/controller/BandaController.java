package com.academify.controller;

import com.academify.model.entity.Banda;
import com.academify.service.BandaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/banda")
public class BandaController {
    private final BandaService bandaService;

    public BandaController(BandaService bandaService) {
        this.bandaService = bandaService;
    }

    @GetMapping("/encontrar")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(bandaService.findAll());
    }

    @PostMapping("/incluir")
    public ResponseEntity save(@RequestBody Banda banda){
        try{
            return ResponseEntity.ok(bandaService.save(banda));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/editar")
    public ResponseEntity edit(@RequestBody Banda banda){
        try{
            return ResponseEntity.ok(bandaService.save(banda));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/encontrar/id/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(bandaService.findById(id));
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(bandaService.delete(id));
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/contagem")
    public ResponseEntity count(){
        return ResponseEntity.ok(bandaService.count());
    }

    @GetMapping("/encontrar/estilo/{estiloMusical}")
    public ResponseEntity getEstiloMusical(@PathVariable("estiloMusical") String estiloMusical){
        List<Banda> bandas = new ArrayList<>();
        for (Banda banda : bandaService.findAll()) {
            if (banda.getEstiloMusical() != null && banda.getEstiloMusical().getNome().equals(estiloMusical)) {
                bandas.add(banda);
            }
        }
        return ResponseEntity.ok(bandas);
    }
}
