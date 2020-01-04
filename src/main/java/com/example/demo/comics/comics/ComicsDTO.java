package com.example.demo.comics.comics;

import com.example.demo.comics.genre.GenreDO;
import com.example.demo.comics.genre.GenreDTO;
import com.example.demo.comics.type.TypeDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ComicsDTO {

    private int id;
    private String name;
    private String status;

    private List<GenreDTO> genres;

    private TypeDTO type;

    ComicsDTO(String name, String status, List<GenreDTO> genres, TypeDTO type ){
        setName(name);
        setStatus(status);
        setType(type);
        setGenres(genres);
    }

    public static ComicsDTO convertToDTO(ComicsDO comicsDO){
        return new ComicsDTO(comicsDO.getName(),comicsDO.getStatus(),
                GenreDTO.convertListToDTO(comicsDO.getGenres()),
                TypeDTO.convertToDTO(comicsDO.getType())
                );
    }

    public static ComicsDO convertToDO(ComicsDTO comicsDTO){
        return new ComicsDO(comicsDTO.getName(),comicsDTO.getStatus(),GenreDTO.convertListToDO(comicsDTO.getGenres()),TypeDTO.convertToDO(comicsDTO.getType()));
    }
}
