package com.example.demo.repository.genreRepository;

import com.example.demo.comics.chapter.ChapterEntity;
import com.example.demo.comics.volume.VolumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChapterRepository extends JpaRepository<ChapterEntity, Integer> {

    @Query("select chapter from ChapterEntity chapter where chapter.name=?1 and chapter.volume=?2")
    ChapterEntity findByNameAndVolume(String name, VolumeEntity volumeEntity);
}
