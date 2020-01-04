package com.example.demo.services.genreService;

import com.example.demo.comics.genre.GenreEntity;
import com.example.demo.comics.genre.GenreDTO;
import com.example.demo.repository.genreRepository.GenreRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public GenreEntity createGenre(GenreDTO genreDTO){
        GenreEntity genreEntity = new GenreEntity();
        if (genreDTO!=null){
            genreEntity.setName(genreDTO.getName());
            genreEntity.setDescription(genreDTO.getDescription());
            return genreRepository.save(genreEntity);
        }
        return genreEntity;
    }

    /*
    Update genre desc
     */
    @Transactional
    public void updateGenre(GenreDTO genreDTO){
        GenreEntity genreEntity = new GenreEntity();
        if (genreDTO != null){
            genreRepository.updateGenreDescription(genreDTO.getName(),genreDTO.getDescription());
        }
    }

    /*
    Get list of all genres
     */
    @Transactional
    public List<GenreDTO> getAllGenres(){
        List<GenreEntity> genreEntities = genreRepository.findAll();
        return GenreDTO.convertListToDTO(genreEntities);
    }

    /*
    Get specific genre by its name
     */
    @Transactional
    public GenreDTO getGenre(String name){
        GenreEntity genreEntity = genreRepository.findByName(name);
        return GenreDTO.convertToDTO(genreRepository.findByName(name));
    }

}
