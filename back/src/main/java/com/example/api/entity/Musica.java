package com.example.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "musicas")
@Data
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String artista;

    private String genero;
}
