package com.example.demo.repository.genreRepository;

import com.example.demo.comics.type.TypeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TypeRepository extends JpaRepository<TypeDO,Integer> {

    TypeDO findByName(String name);

    @Modifying
    @Query("UPDATE TypeDO typedo set typedo.description=?3, typedo.name=?2 where typedo.id =?1")
    void updateDescription(int id,String name, String description);
}
