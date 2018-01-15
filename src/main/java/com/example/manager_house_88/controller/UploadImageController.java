package com.example.manager_house_88.controller;

import com.example.manager_house_88.service.UploadImageService;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadImageController {

    @Autowired
    private UploadImageService imageService;

    @PostMapping("/uploadimage")
    public Object upLoadImage(MultipartFile file){
        return imageService.uploadImage(file);
    }
}
