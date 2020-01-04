package com.example.demo.repository.genreRepository;

import com.example.demo.comics.genre.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {

    @Modifying
    @Query("UPDATE GenreEntity genre set genre.description = ?2 where genre.name = ?1")
    void updateGenreDescription(String name,String description);

    @Query("SELECT genre from GenreEntity genre where genre.name = ?1 group by genre.name")
    GenreEntity findByName(String name);

}
