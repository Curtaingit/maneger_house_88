package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Agency;
import com.example.manager_house_88.service.AgencyService;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency")
@CrossOrigin(origins = {},methods ={RequestMethod.GET,RequestMethod.POST, RequestMethod.OPTIONS})
public class   AgencyController {

    @Autowired
    private AgencyService agencyService;

    @RequestMapping("/findall")
    public Object findAll(@RequestParam(name = "sort",defaultValue = "createtime") String sortName,
                            @RequestParam(name="size",required = false) Integer size,
                            @RequestParam(name = "page",required = false) Integer page){
        Sort sort =new Sort(Sort.Direction.DESC,sortName);
        if(size==null||page==null){
            return  agencyService.findAll(sort);
        }
        Pageable pageable =new PageRequest(page-1,size,sort);
        return agencyService.findAll(pageable);
    }

    @PostMapping("/findone")
    public Object findOne(@RequestParam("agencyid") String agencyId){
        return agencyService.findOne(agencyId);
    }

    @PostMapping("/save")
    public Object save(@RequestBody Agency agency){
        System.out.println(agency);
        agencyService.save(agency);
        return "操作成功";
    }

    @PostMapping("/update")
    public Object update(@RequestParam("agencyid") String agencyId, @RequestBody Agency agency){
        agencyService.update(agencyId,agency);
        return "操作成功";
    }

    @PostMapping("/delete")
    public Object delete(@RequestParam("agencyid") String agencyId){
        agencyService.delete(agencyId);
        return "操作成功";
    }

    @PostMapping("/findbynumber")
    public Object findByNumber(String number){
        return agencyService.findByNumber(number);
    }

}
