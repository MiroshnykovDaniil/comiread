package com.example.demo.controller.comics;


import com.example.demo.comics.chapter.ChapterEntity;
import com.example.demo.services.chapterService.ChapterService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public void addImageToChapter(@RequestParam("files") List<MultipartFile> files, @PathVariable String comicsName, @PathVariable int num, @PathVariable String name) throws IOException {
        chapterService.addImage(files,comicsName,num,name);
    }

    @GetMapping("/{comicsName}/vol/{num}/chapter/{name}/")
    public void getChapterImages(@PathVariable String comicsName, @PathVariable int num, @PathVariable String name, Model model) throws IOException {
        List<MultipartFile> list = chapterService.getImages(comicsName,num,name);
        model.addAttribute("pictures",list);
        chapterService.addImage(list,comicsName,num,"1.0");
    }
}
