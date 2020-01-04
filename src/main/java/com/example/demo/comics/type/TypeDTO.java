package com.example.demo.comics.type;

import lombok.Data;

import java.lang.reflect.Type;
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

    public static TypeDTO convertToDTO(TypeDO typeDO){
        return TypeDTO.createWithId(typeDO.getId(),typeDO.getName(),typeDO.getDescription());
    }

    public static TypeDO convertToDO(TypeDTO typeDTO){
        return TypeDO.createWithID(typeDTO.getId(),typeDTO.getName(),typeDTO.getDescription());
    }

    public static List<TypeDTO> convertListToDTO(List<TypeDO> typeDOS){
        List<TypeDTO> typeDTOS = new ArrayList<>();
        for (TypeDO typeDO : typeDOS) typeDTOS.add(TypeDTO.convertToDTO(typeDO));
        return typeDTOS;
    }

    public static List<TypeDO> convertListToDO(List<TypeDTO> typeDTOS){
        List<TypeDO> typeDOS = new ArrayList<>();
        for (TypeDTO typeDTO : typeDTOS){
            typeDOS.add(TypeDO.createWithID(typeDTO.getId(),typeDTO.getName(),typeDTO.getDescription()));
        }
        return typeDOS;
    }
}
