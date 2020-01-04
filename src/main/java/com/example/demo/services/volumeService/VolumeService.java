package com.example.demo.services.volumeService;


import com.example.demo.comics.comics.ComicsDTO;
import com.example.demo.comics.comics.ComicsEntity;
import com.example.demo.comics.volume.VolumeEntity;
import com.example.demo.files.FileManager;
import com.example.demo.repository.genreRepository.ComicsRepository;
import com.example.demo.repository.genreRepository.VolumeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class VolumeService {

    private final ComicsRepository comicsRepository;
    private final VolumeRepository volumeRepository;

    VolumeService(ComicsRepository comicsRepository, VolumeRepository volumeRepository){
        this.comicsRepository = comicsRepository;
        this.volumeRepository = volumeRepository;
    }

    @Transactional
    public void addVolume(String comicsName){
        ComicsEntity entity = comicsRepository.findByName(comicsName);
        entity.addVolume();
        comicsRepository.updateVolumes(entity.getId(),entity.getVolumes());
        VolumeEntity volume = new VolumeEntity(entity,entity.getVolumes());
        volumeRepository.save(volume);
        FileManager.createFolderForVolume(comicsName, String.valueOf(volume.getVolumeNum()));
    }
}
