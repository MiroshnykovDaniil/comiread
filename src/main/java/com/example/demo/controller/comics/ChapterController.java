package com.example.demo.controller.comics;


import com.example.demo.comics.chapter.ChapterEntity;
import com.example.demo.services.chapterService.ChapterService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

@RestController
@RequestMapping("/comics")
public class ChapterController {

    private final ChapterService chapterService;

    public ChapterController(ChapterService chapterService){
        this.chapterService = chapterService;
    }

    @PostMapping("/{comicsName}/vol/{num}/chapter/{name}/add")
    public ChapterEntity addChapter(@PathVariable String comicsName, @PathVariable int num, @PathVariable String name){
        return chapterService.createChapter(comicsName,num,name);
    }


    @PostMapping("/{comicsName}/vol/{num}/chapter/{name}/image/add")
    public void addImageToChapter(@RequestParam("files") List<byte[]> files, @PathVariable String comicsName, @PathVariable int num, @PathVariable String name) throws IOException {
        chapterService.addImage(files,comicsName,num,name);
    }

    @GetMapping(value = "/{comicsName}/vol/{num}/chapter/{name}/")
    public List<byte[]> getChapterImages(@PathVariable String comicsName, @PathVariable int num, @PathVariable String name, Model model) throws IOException {
        List<byte[]> list = chapterService.getImages(comicsName, num, name);
        model.addAttribute("pictures", list);
        chapterService.addImage(list, comicsName, num, name);
        return list;

    }
}
