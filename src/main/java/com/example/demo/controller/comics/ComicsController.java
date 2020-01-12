package com.example.demo.controller.comics;


import com.example.demo.comics.comics.ComicsEntity;
import com.example.demo.comics.comics.ComicsDTO;
import com.example.demo.files.FileManager;
import com.example.demo.services.comicsService.ComicsService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comics")
public class ComicsController {

    ComicsService comicsService;
    ComicsController(ComicsService comicsService){
        this.comicsService = comicsService;
    }
    @PostMapping("/")
    public void createComics(@RequestBody ComicsDTO comicsDTO){
            comicsService.createComics(comicsDTO);
    }

    @PostMapping("/{name}/image")
    public void uploadImage(@PathVariable String name, @RequestBody byte[] image) throws IOException {
        comicsService.uploadImage(image,name);
    }

    @GetMapping("/{name}/image")
    public List<byte[]> getImage(@PathVariable String name) throws IOException {
        byte[] image = comicsService.getImage(name);
        List<byte[]> imag = new ArrayList<>();
        imag.add(image);
        return imag;
    }

    @GetMapping("/{name}")
    public ComicsDTO  getComicsByName(@PathVariable String name) throws IOException {
        return comicsService.getComicsByName(name);
    }

    @GetMapping("/")
    public List<ComicsDTO> getAll() throws IOException {
        return comicsService.getAll();
    }


}
