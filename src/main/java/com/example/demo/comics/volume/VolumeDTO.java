package com.example.demo.comics.volume;

import com.example.demo.comics.comics.ComicsDTO;
import lombok.Data;

@Data
public class VolumeDTO {

    private int id;

    private int volumeNum;

    private ComicsDTO comicsDTO;


    public static VolumeEntity convertToEntity(VolumeDTO volumeDTO){
        VolumeEntity volumeEntity=new VolumeEntity();
        volumeEntity.setId(volumeDTO.getId());
        volumeEntity.setVolumeNum(volumeDTO.getVolumeNum());
        volumeEntity.setComics(ComicsDTO.convertToDO(volumeDTO.getComicsDTO()));
        return volumeEntity;
    }

}
