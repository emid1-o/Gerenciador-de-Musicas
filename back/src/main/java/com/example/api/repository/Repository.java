package com.example.api.repository;

import com.example.api.entity.Musica;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Musica, Long> {
}
