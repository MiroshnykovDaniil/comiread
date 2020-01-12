package com.example.demo.comics.chapter;

import com.example.demo.comics.comics.ComicsDTO;
import com.example.demo.comics.volume.VolumeDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ChapterDTO {

    private int id;
    private String name;
    private double num;

    private VolumeDTO volume;
    private ComicsDTO comics;

    public ChapterDTO(int id, String name, double num, VolumeDTO volume){
        this.id = id;
        this.name = name;
        this.num = num;
        this.volume = volume;
        this.comics = volume.getComicsDTO();
    }

    public static ChapterDTO convertToDTO(ChapterEntity chapterEntity){
        ChapterDTO chapter = new ChapterDTO(
                chapterEntity.getId(),
                chapterEntity.getName(),
                chapterEntity.getNum(),
                VolumeDTO.convertToDTO(chapterEntity.getVolume())
        );
        return chapter;
    }

    public static List<ChapterDTO> convertListToDTO(List<ChapterEntity> chapterEntities){
        List<ChapterDTO> chapters = new ArrayList<>();
        for (ChapterEntity chapter :  chapterEntities){
            chapters.add(ChapterDTO.convertToDTO(chapter));
        }
        return chapters;
    }
}
