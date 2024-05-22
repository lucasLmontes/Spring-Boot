package com.academify.controller;

import com.academify.model.entity.EstiloMusical;
import com.academify.service.EstiloMusicalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estilo-musical")
public class EstiloMusicalController {
    private final EstiloMusicalService estiloMusicalService;

    public EstiloMusicalController(EstiloMusicalService estiloMusicalService) {
        this.estiloMusicalService = estiloMusicalService;
    }

    @GetMapping()
    public ResponseEntity findAll(){
        return ResponseEntity.ok(estiloMusicalService.findAll());
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody EstiloMusical estiloMusical){
        try{
            return ResponseEntity.ok(estiloMusicalService.save(estiloMusical));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity edit(@RequestBody EstiloMusical estiloMusical){
        try{
            return ResponseEntity.ok(estiloMusicalService.save(estiloMusical));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(estiloMusicalService.findById(id));
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(estiloMusicalService.delete(id));
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/total")
    public ResponseEntity count(){
        return ResponseEntity.ok(estiloMusicalService.count());
    }
}
