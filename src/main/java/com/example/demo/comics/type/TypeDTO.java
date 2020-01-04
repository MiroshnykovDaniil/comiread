package com.example.demo.comics.type;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TypeDTO {

    private int id;
    private String name;
    private String description;

    TypeDTO(String name, String description){
        setName(name);
        setDescription(description);
    }

    public static TypeDTO createWithId(int id, String name, String description){
        TypeDTO typeDTO = new TypeDTO(name,description);
        typeDTO.setId(id);
        return typeDTO;
    }

    public static TypeDTO convertToDTO(TypeEntity typeEntity){
        return TypeDTO.createWithId(typeEntity.getId(), typeEntity.getName(), typeEntity.getDescription());
    }

    public static TypeEntity convertToDO(TypeDTO typeDTO){
        return TypeEntity.createWithID(typeDTO.getId(),typeDTO.getName(),typeDTO.getDescription());
    }

    public static List<TypeDTO> convertListToDTO(List<TypeEntity> typeEntities){
        List<TypeDTO> typeDTOS = new ArrayList<>();
        for (TypeEntity typeEntity : typeEntities) typeDTOS.add(TypeDTO.convertToDTO(typeEntity));
        return typeDTOS;
    }

    public static List<TypeEntity> convertListToDO(List<TypeDTO> typeDTOS){
        List<TypeEntity> typeEntities = new ArrayList<>();
        for (TypeDTO typeDTO : typeDTOS){
            typeEntities.add(TypeEntity.createWithID(typeDTO.getId(),typeDTO.getName(),typeDTO.getDescription()));
        }
        return typeEntities;
    }
}
