package com.example.demo.services.comicsService;

import com.example.demo.comics.comics.ComicsEntity;
import com.example.demo.comics.comics.ComicsDTO;
import com.example.demo.files.FileManager;
import com.example.demo.repository.genreRepository.ComicsRepository;
import org.springframework.stereotype.Service;

@Service
public class ComicsService {

    ComicsRepository comicsRepository;

    ComicsService(ComicsRepository comicsRepository){
        this.comicsRepository = comicsRepository;
    }

    public void createComics(ComicsDTO comicsDTO){

        comicsRepository.save(ComicsDTO.convertToDO(comicsDTO));
        FileManager.createFolderForComics(comicsDTO.getName());
    }

    public ComicsDTO getComicsByName(String name){
        ComicsDTO comicsDTO;
        comicsDTO = ComicsDTO.convertToDTO(comicsRepository.findByName(name));
        return comicsDTO;
    }

}
