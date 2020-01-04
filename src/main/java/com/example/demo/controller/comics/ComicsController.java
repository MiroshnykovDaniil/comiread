package com.example.demo.controller.comics;


import com.example.demo.comics.comics.ComicsDO;
import com.example.demo.comics.comics.ComicsDTO;
import com.example.demo.services.comicsService.ComicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{name}")
    public ComicsDO getComicsByName(@PathVariable String name){
        return comicsService.getComicsByName(name);
    }


}
