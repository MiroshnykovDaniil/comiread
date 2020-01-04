package com.example.demo.comics.chapter;


import com.example.demo.comics.volume.VolumeEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "chapter")
public class ChapterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "volume_id",referencedColumnName = "id")
    private VolumeEntity volume;

    private String name;

    private double num;

    public ChapterEntity(VolumeEntity volume, String name){
        this.volume = volume;
        this.name = name;
        this.num = volume.getComics().getChapters();
    }
}
