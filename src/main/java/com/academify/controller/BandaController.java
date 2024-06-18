package com.academify.controller;

import com.academify.model.entity.Banda;
import com.academify.service.BandaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banda")
public class BandaController {
    private final BandaService bandaService;

    public BandaController(BandaService bandaService) {
        this.bandaService = bandaService;
    }

    @GetMapping()
    public ResponseEntity findAll(){
        return ResponseEntity.ok(bandaService.findAll());
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody Banda banda){
        try{
            return ResponseEntity.ok(bandaService.save(banda));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity edit(@RequestBody Banda banda){
        try{
            return ResponseEntity.ok(bandaService.save(banda));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(bandaService.findById(id));
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(bandaService.delete(id));
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/total")
    public ResponseEntity count(){
        return ResponseEntity.ok(bandaService.count());
    }
}
