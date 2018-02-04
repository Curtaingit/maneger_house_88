package com.example.manager_house_88.controller;

import com.example.manager_house_88.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@CrossOrigin(origins = {},methods ={RequestMethod.GET,RequestMethod.POST,  RequestMethod.OPTIONS})
public class UploadFileController {

    @Value("${imagepath}")
    String imagepath;

    @Autowired
    private UploadFileService imageService;

    @PostMapping("/uploadimage")
    public Object uploadImage(MultipartFile file){
        return imageService.uploadImage(file);
    }


    @PostMapping("/deleteimage")
    public Object deleteImage(@RequestParam("imagename") String imageName){
        File file = new File(imagepath+"imageName");
        file.delete();
        return "操作成功";
    }

    @PostMapping("/uploadvideo")
    public Object uploadVideo(MultipartFile file){
        return imageService.uploadVideo(file);
    }

}
