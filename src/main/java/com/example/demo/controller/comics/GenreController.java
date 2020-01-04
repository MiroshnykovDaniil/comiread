package com.example.demo.controller.comics;


import com.example.demo.comics.genre.GenreDO;
import com.example.demo.comics.genre.GenreDTO;
import com.example.demo.services.genreService.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
REST repository for Genres of content
 */

@RestController
@RequestMapping(path = "/genre")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    GenreController(GenreService genreService){
        this.genreService = genreService;
    }

    /*
    Get list of all genres
     */
    @GetMapping(path = "/")
    public List<GenreDTO> getAll(){
        return genreService.getAllGenres();
    }

    /*
    Create a new genre
     */
    @PostMapping("/")
    public GenreDO createGenre(@RequestBody GenreDTO genreDTO){
        return genreService.createGenre(genreDTO);
    }

    /*
    Update genre description
     */
    @PutMapping("/")
    public void updateGenre(@RequestBody GenreDTO genreDTO){
        genreService.updateGenre(genreDTO);
    }

/*
Get specific genre by its name
 */
    @GetMapping(path = "/{name}")
    public GenreDTO getGenre(@PathVariable String name){
        return genreService.getGenre(name);
    }
}
