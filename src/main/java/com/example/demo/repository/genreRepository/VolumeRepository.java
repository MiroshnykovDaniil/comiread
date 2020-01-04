package com.example.demo.repository.genreRepository;

import com.example.demo.comics.comics.ComicsEntity;
import com.example.demo.comics.volume.VolumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VolumeRepository extends JpaRepository<VolumeEntity, Integer> {

    @Query("select volume from VolumeEntity volume where volume.volumeNum=?2 and volume.comics = ?1")
    VolumeEntity findByVolumeNum(ComicsEntity comicsEntity, int num);

}
