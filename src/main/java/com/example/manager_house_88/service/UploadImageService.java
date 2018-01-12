package com.example.manager_house_88.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImageService {

    /*上传图片*/
    String uploadImage(MultipartFile file);

}
