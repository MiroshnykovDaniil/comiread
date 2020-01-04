package com.example.demo.controller.comics;

import com.example.demo.comics.type.TypeDTO;
import com.example.demo.services.typeService.TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
REST Controller for Types of content
 */

@RestController
@RequestMapping("/type")
public class TypeController {

    private final TypeService typeService;

    TypeController(TypeService typeService){
        this.typeService = typeService;
    }

    @GetMapping("/")
    public List<TypeDTO> getAllTypes(){
        return typeService.getAllTypes();
    }

    @GetMapping("/{name}")
    public TypeDTO getType(@PathVariable String name){
        return typeService.getType(name);
    }

    @PostMapping("/")
    public void createType(@RequestBody TypeDTO typeDTO){
        typeService.createType(typeDTO);
    }

    @PutMapping("/")
    public void updateType(@RequestBody TypeDTO typeDTO){
        typeService.updateType(typeDTO);
    }
}
