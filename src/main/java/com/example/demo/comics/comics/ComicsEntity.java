package com.example.demo.comics.comics;


import com.example.demo.comics.genre.GenreEntity;
import com.example.demo.comics.type.TypeEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "comics")
public class ComicsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String name;

    // Status of comics: ongoing, ended
    private String status;

    //genre
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "genres_id",referencedColumnName = "id")
    private List<GenreEntity> genres;

    //type
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeEntity type;

    @Column(columnDefinition = "int default 0")
    private int volumes=0;

    @Column(columnDefinition = "int default 0")
    private int chapters = 0;

    public ComicsEntity(String name, String status, List<GenreEntity> genres, TypeEntity type){
        setName(name);
        setStatus(status);
        setGenres(genres);
        setType(type);
    }

    public void addChapter(){setChapters(getChapters()+1);}

    public void addVolume(){
        setVolumes(getVolumes()+1);
    }
}
