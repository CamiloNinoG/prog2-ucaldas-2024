package com.example3.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import com.example3.demo.domain.Cerveza;
import com.example3.demo.repository.CervezaRepository;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api")
public class CervezaController {

    @Autowired
    CervezaRepository cervezaRepository;

    @GetMapping("/cervezas")
    public ResponseEntity<List<Cerveza>> getAllCervezas(@RequestParam(required = false) String cerveceria) {
        try {
            List<Cerveza> cervezas = new ArrayList<>();

            if (cerveceria == null) {
                cervezas.addAll(cervezaRepository.findAll());
            } else {
                cervezas.addAll(cervezaRepository.findByCerveceria(cerveceria));
            }

            return new ResponseEntity<>(cervezas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cervezas/{id}")
    public ResponseEntity<Cerveza> getCervezaById(@PathVariable("id") Long id) {
        Optional<Cerveza> cervezaData = cervezaRepository.findById(id);

        if (cervezaData.isPresent()) {
            return new ResponseEntity<>(cervezaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/cervezas")
    public ResponseEntity<Cerveza> createCerveza(@RequestBody Cerveza cerveceria) {
        try {
            Cerveza _cerveza = cervezaRepository.save(new Cerveza(cerveceria.getCerveceria(), cerveceria.getDepartamento(), cerveceria.getMunicipio(), cerveceria.getNomenclatura(), cerveceria.getMarca(), cerveceria.getStock()));
            return new ResponseEntity<>(_cerveza, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cervezas/{id}")
    public ResponseEntity<Cerveza> updateCerveza(@PathVariable("id") Long id, @RequestBody Cerveza cerveceria) {
        Optional<Cerveza> cervezaData = cervezaRepository.findById(id);

        if (cervezaData.isPresent()) {
            Cerveza cerveza_ = cervezaData.get();
            cerveza_.setCerveceria(cerveceria.getCerveceria());
            cerveza_.setDepartamento(cerveceria.getDepartamento());
            cerveza_.setMunicipio(cerveceria.getMunicipio());
            cerveza_.setNomenclatura(cerveceria.getNomenclatura());
            cerveza_.setMarca(cerveceria.getMarca());
            cerveza_.setStock(cerveceria.getStock());
            cervezaRepository.save(cerveza_); // Save the updated cerveceria
            return new ResponseEntity<>(cerveza_, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cervezas/{id}")
    public ResponseEntity<HttpStatus> deleteCerveza(@PathVariable("id") Long id) {
        try {
            cervezaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE ALL DATA (;C)
    // @DeleteMapping("/cervezas")
    // public ResponseEntity<HttpStatus> deleteAllCervezas(){
    // try{
    // cervezaRepository.deleteAll();
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // } catch (Exception e){
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }
}
