package com.example.demo.services.comicsService;

import com.example.demo.comics.comics.ComicsDO;
import com.example.demo.comics.comics.ComicsDTO;
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
    }

    public ComicsDO getComicsByName(String name){
        return comicsRepository.findByName(name);
    }
}
