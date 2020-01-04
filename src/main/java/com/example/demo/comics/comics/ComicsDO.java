package com.example.demo.comics.comics;


import com.example.demo.comics.genre.GenreDO;
import com.example.demo.comics.genre.GenreDTO;
import com.example.demo.comics.type.TypeDO;
import com.example.demo.comics.type.TypeDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Year;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "comics")
public class ComicsDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String name;

    // Status of comics: ongoing, ended
    private String status;

    //Year of release
  //  private Year release;

    //genre
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "genres_id",referencedColumnName = "id")
    private List<GenreDO> genres;

    //type
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeDO type;

    public ComicsDO(String name, String status, List<GenreDO> genres, TypeDO type){
        setName(name);
        setStatus(status);
        setGenres(genres);
        setType(type);
    }
}
