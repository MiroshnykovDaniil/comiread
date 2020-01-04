package com.example.demo.comics.genre;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

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


    public static GenreDTO convertToDTO(GenreDO genreDO){
        return new GenreDTO(genreDO.getId(),genreDO.getName(),genreDO.getDescription());
    }

    public static List<GenreDTO> convertListToDTO(List<GenreDO> genreDOS){
        List<GenreDTO> genreDTOS  = new ArrayList<>();
        for(GenreDO genreDO : genreDOS){
            genreDTOS.add(new GenreDTO(genreDO.getId(),genreDO.getName(),genreDO.getDescription()));
        }
        return genreDTOS;
    }

    public static List<GenreDO> convertListToDO(List<GenreDTO> genreDTOS){
        List<GenreDO> genreDOS = new ArrayList<>();
        for (GenreDTO genreDTO : genreDTOS){
            genreDOS.add(GenreDO.createWithID(genreDTO.getId(),genreDTO.getName(),genreDTO.getDescription()));
        }
        return genreDOS;
    }


}
