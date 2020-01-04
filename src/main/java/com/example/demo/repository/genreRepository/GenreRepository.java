package com.example.demo.repository.genreRepository;

import com.example.demo.comics.genre.GenreDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreDO, Integer> {

    @Modifying
    @Query("UPDATE GenreDO genre set genre.description = ?2 where genre.name = ?1")
    void updateGenreDescription(String name,String description);

    @Query("SELECT genre from GenreDO genre where genre.name = ?1 group by genre.name")
    GenreDO findByName(String name);

}
