package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Document;
import com.example.manager_house_88.service.DocumentService;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cx on 18-1-10.
 */

@CrossOrigin(origins = {},methods ={RequestMethod.GET,RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping("/document")
@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/findone")
    public Object findOne(@RequestParam(name = "documentid") String documentId) {
        return documentService.findOne(documentId);
    }

    @RequestMapping("/findall")
    public Object findAll(@RequestParam(name = "sort", defaultValue = "createtime") String sortName,
                          @RequestParam(name = "size", required = false) Integer size,
                          @RequestParam(name = "page", required = false) Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, sortName);
        if (size == null || page == null) {
            return ResultVOUtil.success(documentService.findAll(sort));
        }
        Pageable pageable = new PageRequest(page-1, size, sort);
        return documentService.findAll(pageable);
    }

    @PostMapping("/save")
    public Object save(
            @RequestParam(name = "scheduleid") String scheduleId,
            @RequestBody Document document) {
        return documentService.save(scheduleId, document);
    }

    @PostMapping("/findbyuserid")
    public Object findByUserId(@RequestParam("userid") String userId) {
        return documentService.findByUserId(userId);
    }

    @PostMapping("/changestatus")
    public Object changeStatus(@RequestParam(name = "documentid") String documentId) {
        documentService.changeStatus(documentId);
        return "操作成功";
    }

}
