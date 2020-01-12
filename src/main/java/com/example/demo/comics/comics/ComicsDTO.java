package com.example.demo.comics.comics;

import com.example.demo.comics.genre.GenreDTO;
import com.example.demo.comics.type.TypeDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ComicsDTO {

    private int id;
    private String name;
    private String status;

    private List<GenreDTO> genres;

    private TypeDTO type;

    private int volumes=0;
    private int chapters = 0;

    private byte[] image;

    ComicsDTO(int id,String name, String status, List<GenreDTO> genres, TypeDTO type, int volumes, int chapters){
        setId(id);
        setName(name);
        setStatus(status);
        setType(type);
        setGenres(genres);
        setVolumes(volumes);
        setChapters(chapters);
    }

    public static ComicsDTO convertToDTO(ComicsEntity comicsEntity){
        return new ComicsDTO(comicsEntity.getId(),comicsEntity.getName(), comicsEntity.getStatus(),
                GenreDTO.convertListToDTO(comicsEntity.getGenres()),
                TypeDTO.convertToDTO(comicsEntity.getType()),
                comicsEntity.getVolumes(),
                comicsEntity.getChapters()
                );
    }

    public static ComicsEntity convertToDO(ComicsDTO comicsDTO){
        return new ComicsEntity(comicsDTO.getName(),comicsDTO.getStatus(),GenreDTO.convertListToDO(comicsDTO.getGenres()),TypeDTO.convertToDO(comicsDTO.getType()));
    }

    public static List<ComicsDTO> convertListToDTO(List<ComicsEntity> entityList){
        List<ComicsDTO> list = new ArrayList<>();
        for(ComicsEntity comicsEntity : entityList)
            list.add(convertToDTO(comicsEntity));
        return list;
    }

}
