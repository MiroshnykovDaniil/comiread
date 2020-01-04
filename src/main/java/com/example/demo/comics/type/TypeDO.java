package com.example.demo.comics.type;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "types")
@NoArgsConstructor
public class TypeDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String description;

    public TypeDO(String name, String description){
        setName(name);
        setDescription(description);
    }

    public static TypeDO createWithID(int id, String name, String description){
        TypeDO typeDO = new TypeDO(name, description);
        typeDO.setId(id);
        return typeDO;
    }
}
