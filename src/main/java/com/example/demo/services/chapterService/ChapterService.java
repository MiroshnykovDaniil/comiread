package com.example.demo.services.chapterService;
import com.example.demo.comics.chapter.ChapterEntity;
import com.example.demo.comics.comics.ComicsEntity;
import com.example.demo.comics.volume.VolumeDTO;
import com.example.demo.comics.volume.VolumeEntity;
import com.example.demo.files.FileManager;
import com.example.demo.repository.genreRepository.ChapterRepository;
import com.example.demo.repository.genreRepository.ComicsRepository;
import com.example.demo.repository.genreRepository.VolumeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final ComicsRepository comicsRepository;
    private final VolumeRepository volumeRepository;

    ChapterService(ChapterRepository chapterRepository, ComicsRepository comicsRepository, VolumeRepository volumeRepository){
        this.chapterRepository = chapterRepository;
        this.comicsRepository = comicsRepository;
        this.volumeRepository = volumeRepository;
    }

    @Transactional
    public ChapterEntity createChapter(String comicsName,int num, String chapterName){
        ComicsEntity comicsEntity = comicsRepository.findByName(comicsName);

        VolumeEntity volumeEntity = volumeRepository.findByVolumeNum(comicsEntity,num);

        comicsEntity.setChapters(comicsEntity.getChapters()+1);

        ChapterEntity chapter = new ChapterEntity(volumeEntity, chapterName);

        comicsRepository.updateChapters(comicsEntity.getId(),comicsEntity.getChapters());
        chapterRepository.save(chapter);

        FileManager.createFolderForChapter(comicsName,String.valueOf(volumeEntity.getVolumeNum()),chapterName);

        return chapter;
    }

    public void addImage(List<MultipartFile> files, String comicsName, int num, String chapterName) throws IOException {
        ComicsEntity comicsEntity = comicsRepository.findByName(comicsName);
        VolumeEntity volumeEntity = volumeRepository.findByVolumeNum(comicsEntity,num);

        ChapterEntity chapterEntity = chapterRepository.findByNameAndVolume(chapterName,volumeEntity);

        FileManager.uploadImages(files,comicsName,String.valueOf(num),chapterName);

    }

    public List<MultipartFile> getImages(String comicsName, int num, String chapterName) throws IOException {
        return FileManager.getImages(comicsName,String.valueOf(num),chapterName);
    }
}
