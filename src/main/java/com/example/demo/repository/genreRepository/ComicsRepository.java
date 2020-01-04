package com.example.demo.repository.genreRepository;

import com.example.demo.comics.comics.ComicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ComicsRepository extends JpaRepository<ComicsEntity,Integer> {

    ComicsEntity findByName(String name);

    @Modifying
    @Query("update ComicsEntity comics set comics.volumes = ?2 where comics.id=?1")
    void updateVolumes(int id, int volume);

    @Modifying
    @Query("update ComicsEntity comics set comics.chapters=?2 where comics.id = ?1")
    void updateChapters(int id, int chapters);
}
