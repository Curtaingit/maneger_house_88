package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Document;
import com.example.manager_house_88.service.DocumentService;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cx on 18-1-10.
 */


@RequestMapping("/document")
@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/findone")
    public ResultVO findOne(@RequestParam(name = "documentid") String documentId) {
        return ResultVOUtil.success(documentService.findOne(documentId));
    }

    @GetMapping("/findall")
    public ResultVO findAll(@RequestParam(name = "sort",defaultValue = "createtime") String sortName){
        Sort sort =new Sort(Sort.Direction.DESC,sortName);
        return ResultVOUtil.success(documentService.findAll(sort)) ;
    }

    @PostMapping("/save")
    public ResultVO save(@RequestBody Document document){
        return ResultVOUtil.success(documentService.save(document));
    }


}
