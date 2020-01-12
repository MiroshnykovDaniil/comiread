package com.example.demo.services.comicsService;

import com.example.demo.comics.comics.ComicsEntity;
import com.example.demo.comics.comics.ComicsDTO;
import com.example.demo.files.FileManager;
import com.example.demo.repository.genreRepository.ComicsRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComicsService {

    ComicsRepository comicsRepository;

    ComicsService(ComicsRepository comicsRepository){
        this.comicsRepository = comicsRepository;
    }

    public void createComics(ComicsDTO comicsDTO) {

        comicsRepository.save(ComicsDTO.convertToDO(comicsDTO));
        FileManager.createFolderForComics(comicsDTO.getName());
    }

    public byte[] getImage(String name) throws IOException {
        return FileManager.getComicsCardImage(name);
    }

    public void uploadImage(byte[] image,String name) throws IOException {
        FileManager.uploadComicsCardImage(image,name);
    }

    public ComicsDTO getComicsByName(String name) throws IOException {
        ComicsDTO comicsDTO;
        comicsDTO = ComicsDTO.convertToDTO(comicsRepository.findByName(name));
        comicsDTO.setImage(FileManager.getComicsCardImage(name));
        return comicsDTO;
    }

    public List<ComicsDTO> getAll() throws IOException {
        List<ComicsDTO> list = new ArrayList<>();
        list = ComicsDTO.convertListToDTO(comicsRepository.findAll());
        for (ComicsDTO comicsDTO : list) comicsDTO.setImage(FileManager.getComicsCardImage(comicsDTO.getName()));
        return list;
    }

}
