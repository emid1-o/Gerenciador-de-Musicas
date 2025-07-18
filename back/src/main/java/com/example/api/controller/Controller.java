package com.example.api.controller;

import com.example.api.entity.Musica;
import com.example.api.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/")
    public ResponseEntity<String> cadastrar(@RequestBody Musica musica){

        try {
            return new ResponseEntity<>(service.save(musica), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Algo deu errado", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Musica>> listar(){

        try{

            return new ResponseEntity<>(service.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editar(@RequestBody Musica musica, @PathVariable Long id){

        try {
            return new ResponseEntity<>(service.editById(id, musica), HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        try {
            return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("ID não encontrado", HttpStatus.BAD_REQUEST);
        }
    }
}
