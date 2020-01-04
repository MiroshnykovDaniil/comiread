package com.example.demo.services.genreService;

import com.example.demo.comics.genre.GenreDO;
import com.example.demo.comics.genre.GenreDTO;
import com.example.demo.repository.genreRepository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;


    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    /*
    Create new genre
     */
    @Transactional
    public GenreDO createGenre(GenreDTO genreDTO){
        GenreDO genreDO = new GenreDO();
        if (genreDTO!=null){
            genreDO.setName(genreDTO.getName());
            genreDO.setDescription(genreDTO.getDescription());
            return genreRepository.save(genreDO);
        }
        return genreDO;
    }

    /*
    Update genre desc
     */
    @Transactional
    public void updateGenre(GenreDTO genreDTO){
        GenreDO genreDO = new GenreDO();
        if (genreDTO != null){
            genreRepository.updateGenreDescription(genreDTO.getName(),genreDTO.getDescription());
        }
    }

    /*
    Get list of all genres
     */
    @Transactional
    public List<GenreDTO> getAllGenres(){
        List<GenreDO> genreDOS = genreRepository.findAll();
        return GenreDTO.convertListToDTO(genreDOS);
    }

    /*
    Get specific genre by its name
     */
    @Transactional
    public GenreDTO getGenre(String name){
        GenreDO genreDO = genreRepository.findByName(name);
        return GenreDTO.convertToDTO(genreRepository.findByName(name));
    }

}
