package com.example.api.service;

import com.example.api.entity.Musica;
import com.example.api.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;

    public String deleteById(Long id){

         repository.deleteById(id);
         return "Música de id " + id + " foi deletada com sucesso";

    }

    public String save(Musica musica){

        repository.save(musica);
        return "Música " + musica.getNome() + " salva com sucesso!";
    }

    public Iterable<Musica> findAll(){

        return repository.findAll();
    }

    public String editById(Long id, Musica musica){

        if (repository.existsById(id)){
            Musica velha = repository.findById(id).get();
            velha.setArtista(musica.getArtista());
            velha.setGenero(musica.getGenero());
            velha.setNome(musica.getNome());
            repository.save(velha);


            return "Musica editada com sucesso";
        }
        return "Id não encontrado";
    }
}
