package com.example.demo.comics.volume;


import com.example.demo.comics.comics.ComicsEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "volume")
public class VolumeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int volumeNum;

    @ManyToOne()
    @JoinColumn(name = "comics_id",referencedColumnName = "id")
    private ComicsEntity comics;

    public VolumeEntity(ComicsEntity comics, int num){
        setComics(comics);
        setVolumeNum(num);
    }
}
