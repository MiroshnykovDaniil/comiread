package com.example.demo.files;

import org.apache.commons.io.FileUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
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

    public static void uploadImages(List<byte[]> files, String comicsName, String volumeNum, String chapterName) throws IOException {
        int i=0;
        for (byte[] file : files){
            FileUtils.writeByteArrayToFile(new File("C:\\Users\\Владелец\\IdeaProjects\\comiread\\storage\\"+comicsName+"\\"+volumeNum+"\\"+chapterName+"\\"+i+".jpg"), file);
            i++;
        }
        return;
    }

    public static List<byte[]> getImages(String comicsName, String volumeNum, String chapterName) throws IOException {

        List<byte[]> bytes = new ArrayList<>();

        File folder = new File("C:\\Users\\Владелец\\IdeaProjects\\comiread\\storage\\"+comicsName+"\\"+volumeNum+"\\"+chapterName);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
               bytes.add(Files.readAllBytes(file.toPath()));
            }
        }
        return bytes;
    }

    public static void uploadComicsCardImage(byte[] image, String comicsName) throws IOException {
        FileUtils.writeByteArrayToFile(new File("C:\\Users\\Владелец\\IdeaProjects\\comiread\\storage\\"+comicsName+"\\card.jpg"), image);
    }

    public static byte[] getComicsCardImage(String comicsName) throws IOException{
        File folder = new File("C:\\Users\\Владелец\\IdeaProjects\\comiread\\storage\\"+comicsName+"\\card.jpg");
        byte[] image = Files.readAllBytes(folder.toPath());
        return image;
    }
}
