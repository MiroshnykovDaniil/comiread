package com.example.demo.comics.volume;

import com.example.demo.comics.comics.ComicsDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VolumeDTO {

    private int id;

    private int volumeNum;

    private ComicsDTO comicsDTO;

    public VolumeDTO(int id, int volumeNum, ComicsDTO comicsDTO){
        this.id = id;
        this.volumeNum = volumeNum;
        this.comicsDTO = comicsDTO;
    }


    public static VolumeEntity convertToEntity(VolumeDTO volumeDTO){
        VolumeEntity volumeEntity=new VolumeEntity();
        volumeEntity.setId(volumeDTO.getId());
        volumeEntity.setVolumeNum(volumeDTO.getVolumeNum());
        volumeEntity.setComics(ComicsDTO.convertToDO(volumeDTO.getComicsDTO()));
        return volumeEntity;
    }

    public static VolumeDTO convertToDTO(VolumeEntity volumeEntity){
        VolumeDTO volumeDTO = new VolumeDTO(
                volumeEntity.getId(),
                volumeEntity.getVolumeNum(),
                ComicsDTO.convertToDTO(volumeEntity.getComics())
        );
        return volumeDTO;
    }

}
