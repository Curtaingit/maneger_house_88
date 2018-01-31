package com.example.manager_house_88.controller;

import com.example.manager_house_88.service.UploadImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@CrossOrigin(origins = {},methods ={RequestMethod.GET,RequestMethod.POST,  RequestMethod.OPTIONS})
public class UploadImageController {

    @Value("${imagepath}")
    String path;

    @Autowired
    private UploadImageService imageService;

    @PostMapping("/uploadimage")
    public Object upLoadImage(MultipartFile file){
        return imageService.uploadImage(file);
    }


    @PostMapping("/deleteimage")
    public Object deleteImage(@RequestParam("imagename") String imageName){
        File file = new File(path+"imageName");
        file.delete();
        return "操作成功";
    }
}
