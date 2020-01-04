package com.example.demo.files;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class FileManager {


    public static void createFolderForComics(String comicsName){
        File file = new File("C:\\Users\\Владелец\\IdeaProjects\\comiread\\storage\\"+comicsName);
        if (!file.exists()) {
            if (file.mkdir()) {
            }
        } else {
            createFolderForComics(comicsName);
        }
    }

    public static void createFolderForVolume(String comicsName, String volumeNum){
        File file = new File("C:\\Users\\Владелец\\IdeaProjects\\comiread\\storage\\"+comicsName+"\\"+volumeNum);
        if (!file.exists()) {
            if (file.mkdir()) {
            }
        } else {
            createFolderForVolume(comicsName, volumeNum);
        }
    }

    public static void createFolderForChapter(String comicsName, String volumeNum, String chapterName){
        File file = new File("C:\\Users\\Владелец\\IdeaProjects\\comiread\\storage\\"+comicsName+"\\"+volumeNum+"\\"+chapterName);
        if (!file.exists()) {
            if (file.mkdir()) {
            }
        } else {
            createFolderForChapter(comicsName, volumeNum,chapterName);
        }
    }

    public static void uploadImages(List<MultipartFile> files, String comicsName, String volumeNum, String chapterName) throws IOException {

        for (MultipartFile file : files){
            if (file.isEmpty()) {
                continue;
            }
            else{
                File newFile = new File("C:\\Users\\Владелец\\IdeaProjects\\comiread\\storage\\"+comicsName+"\\"+volumeNum+"\\"+chapterName+"\\"+file.getName());
                file.transferTo(newFile);
            }
        }
    }

    public static List<MultipartFile> getImages(String comicsName, String volumeNum, String chapterName) throws IOException {
        List<MultipartFile> files = new ArrayList<>();

        File folder = new File("C:\\Users\\Владелец\\IdeaProjects\\comiread\\storage\\"+comicsName+"\\"+volumeNum+"\\"+chapterName);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                FileInputStream input = new FileInputStream(file);
                MultipartFile multipartFile = new MockMultipartFile(file.getName(),
                        file.getName(), "text/plain", IOUtils.toByteArray(input));
                files.add(multipartFile);
            }
        }
        return files;
    }
}
