package com.example.manager_house_88.service;

import org.springframework.web.multipart.MultipartFile;

public interface UpLoadImageService {

    /*上传图片*/
    String upLoadImage(MultipartFile file);

}
