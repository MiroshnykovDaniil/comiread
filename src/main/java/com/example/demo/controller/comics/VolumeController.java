package com.example.demo.controller.comics;

import com.example.demo.files.FileManager;
import com.example.demo.services.volumeService.VolumeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comics")
public class VolumeController {

    private final VolumeService volumeService;

    VolumeController(VolumeService volumeService){
        this.volumeService = volumeService;
    }

    @PostMapping("/{name}/volume/add/")
    public void createVolume(@PathVariable String name){

        volumeService.addVolume(name);
    }
}
