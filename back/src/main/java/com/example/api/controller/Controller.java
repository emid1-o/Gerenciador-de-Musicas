package com.example.api.controller;

import com.example.api.entity.Musica;
import com.example.api.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    private Repository acao;

    @PostMapping("/")
    public String cadastrar(@RequestBody Musica musica){
        if (musica.getNome().isEmpty() || musica.getArtista().isEmpty() || musica.getGenero().isEmpty()){

            return "Preencha todos os dados";
        }
        acao.save(musica);
        return "Musica cadastrada com sucesso!";
    }

    @GetMapping("/")
    public Iterable<Musica> listar(){

        return acao.findAll();
    }

    @PutMapping("/")
    public String editar(@RequestBody Musica musica){
        if (musica.getNome().isEmpty() || musica.getArtista().isEmpty() || musica.getGenero().isEmpty()){

            return "Preencha todos os dados";
        }
        acao.save(musica);
        return "Musica editada com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){

        if (!acao.existsById(id)){
            return "Musica de id " + id + " não está cadastrada no sistema";
        }
        acao.deleteById(id);
        return "Musica deletada com sucesso!";
    }
}
