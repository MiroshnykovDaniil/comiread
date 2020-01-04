package com.example.demo.comics.genre;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class GenreDTO {
    private int id;
    private String name;
    private String description;

    GenreDTO(String name, String description){
        setName(name);
        setDescription(description);
    }

    GenreDTO(int id, String name, String description){
        setId(id);
        setName(name);
        setDescription(description);
    }


    public static GenreDTO convertToDTO(GenreEntity genreEntity){
        return new GenreDTO(genreEntity.getId(), genreEntity.getName(), genreEntity.getDescription());
    }

    public static List<GenreDTO> convertListToDTO(List<GenreEntity> genreEntities){
        List<GenreDTO> genreDTOS  = new ArrayList<>();
        for(GenreEntity genreEntity : genreEntities){
            genreDTOS.add(new GenreDTO(genreEntity.getId(), genreEntity.getName(), genreEntity.getDescription()));
        }
        return genreDTOS;
    }

    public static List<GenreEntity> convertListToDO(List<GenreDTO> genreDTOS){
        List<GenreEntity> genreEntities = new ArrayList<>();
        for (GenreDTO genreDTO : genreDTOS){
            genreEntities.add(GenreEntity.createWithID(genreDTO.getId(),genreDTO.getName(),genreDTO.getDescription()));
        }
        return genreEntities;
    }


}
