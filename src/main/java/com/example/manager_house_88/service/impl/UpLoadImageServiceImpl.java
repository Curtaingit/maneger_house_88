package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.service.UpLoadImageService;
import com.example.manager_house_88.utils.FileUtil;
import com.example.manager_house_88.utils.KeyUtil;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UpLoadImageServiceImpl implements UpLoadImageService {

    @Value("${imagepath}")
    String filepath;

    @Value("${imageurl}")
    String returnurl;

    @Override
    public String upLoadImage(MultipartFile file) {
        String fileName = KeyUtil.genUniqueKey() + file.getOriginalFilename();
        String filePath = filepath;
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            ResultVOUtil.error("上传失败");
        }

        return  returnurl + fileName;
    }
}
