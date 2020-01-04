package com.example.demo.comics.genre;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "genres")
@NoArgsConstructor
@Data
public class GenreDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    GenreDO(String name, String description){
        setName(name);
        setDescription(description);
    }

    public static GenreDO createWithID(int id, String name, String description){
        GenreDO genreDO = new GenreDO(name,description);
        genreDO.setId(id);
        return genreDO;
    }
}
