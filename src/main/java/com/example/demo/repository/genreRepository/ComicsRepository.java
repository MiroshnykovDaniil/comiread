package com.example.demo.repository.genreRepository;

import com.example.demo.comics.comics.ComicsDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicsRepository extends JpaRepository<ComicsDO,Integer> {

    ComicsDO findByName(String name);

}
