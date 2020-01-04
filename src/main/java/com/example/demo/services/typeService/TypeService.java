package com.example.demo.services.typeService;

import com.example.demo.comics.type.TypeEntity;
import com.example.demo.comics.type.TypeDTO;
import com.example.demo.repository.genreRepository.TypeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/*
Service for types requests
 */

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    TypeService(TypeRepository typeRepository){
        this.typeRepository = typeRepository;
    }

    public List<TypeDTO> getAllTypes(){
        return TypeDTO.convertListToDTO(typeRepository.findAll());
    }

    public TypeDTO getType(String name){
        return TypeDTO.convertToDTO(typeRepository.findByName(name));
    }

    public void createType(TypeDTO typeDTO){
        typeRepository.save(new TypeEntity(typeDTO.getName(),typeDTO.getDescription()));
    }

    @Transactional
    public void updateType(TypeDTO typeDTO){
        typeRepository.updateDescription(typeDTO.getId(),typeDTO.getName(),typeDTO.getDescription());
    }
}
