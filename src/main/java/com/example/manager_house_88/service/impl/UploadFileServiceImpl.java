package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.exception.ManagerHouse88Exception;
import com.example.manager_house_88.service.UploadFileService;
import com.example.manager_house_88.utils.FileUtil;
import com.example.manager_house_88.utils.KeyUtil;
import com.example.manager_house_88.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    @Value("${imagepath}")
    String imagepath;

    @Value("${videopath}")
    String videopath;

    @Value("${imageurl}")
    String returnurl;

    public static boolean isValid(String contentType, String... allowTypes) {
        if (null == contentType || "".equals(contentType)) {
            return false;
        }
        for (String type : allowTypes) {
            if (contentType.indexOf(type) > -1) {
                return true;
            }
        }
        return false;
    }


    /*上传图片*/
    @Override
    public String uploadImage(MultipartFile file) {
        String fileName = KeyUtil.genUniqueKey() + file.getOriginalFilename();
        String d = file.getName();
        try {
            FileUtil.uploadFile(file.getBytes(), imagepath, fileName);
        } catch (Exception e) {
            ResultVOUtil.error("上传失败");
        }

        return returnurl + fileName;
    }

    @Override
    public String uploadVideo(MultipartFile file) {
        String fileName = KeyUtil.genUniqueKey() + file.getOriginalFilename();
        String[] allowTypes = new String[]{".MP4", ".mp4",".webm", ".ogg"};
        Boolean CanUploaded = isValid( file.getOriginalFilename(), allowTypes);
        if (CanUploaded){
            try {
                FileUtil.uploadFile(file.getBytes(), videopath, fileName);
            } catch (Exception e) {
                ResultVOUtil.error("上传失败");
            }

            return fileName;
        }else {
            throw new ManagerHouse88Exception("文件格式不正确!");
        }

    }
}
