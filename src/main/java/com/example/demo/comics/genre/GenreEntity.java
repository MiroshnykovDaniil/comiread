package com.example.demo.comics.genre;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "genres")
@NoArgsConstructor
@Data
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    GenreEntity(String name, String description){
        setName(name);
        setDescription(description);
    }

    public static GenreEntity createWithID(int id, String name, String description){
        GenreEntity genreEntity = new GenreEntity(name,description);
        genreEntity.setId(id);
        return genreEntity;
    }
}
