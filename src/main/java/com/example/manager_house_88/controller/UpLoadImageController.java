package com.example.manager_house_88.controller;

import com.example.manager_house_88.service.UpLoadImageService;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UpLoadImageController {

    @Autowired
    private UpLoadImageService imageService;

    @PostMapping("/uploadimage")
    public ResultVO upLoadImage(MultipartFile file){
        return ResultVOUtil.success(imageService.upLoadImage(file));
    }
}
