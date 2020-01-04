package com.example.demo.comics.type;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "types")
@NoArgsConstructor
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String description;

    public TypeEntity(String name, String description){
        setName(name);
        setDescription(description);
    }

    public static TypeEntity createWithID(int id, String name, String description){
        TypeEntity typeEntity = new TypeEntity(name, description);
        typeEntity.setId(id);
        return typeEntity;
    }
}
