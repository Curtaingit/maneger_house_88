package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Agency;
import com.example.manager_house_88.service.AgencyService;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @RequestMapping("/findall")
    public ResultVO findAll(@RequestParam(name = "sort",defaultValue = "createtime") String sortName,
                            @RequestParam(name="size",required = false) Integer size,
                            @RequestParam(name = "page",required = false) Integer page){
        Sort sort =new Sort(Sort.Direction.DESC,sortName);
        if(size==null||page==null){
            return  ResultVOUtil.success(agencyService.findAll(sort));
        }
        Pageable pageable =new PageRequest(page,size,sort);
        return ResultVOUtil.success(agencyService.findAll(pageable)) ;
    }

    @PostMapping("/findone")
    public ResultVO findOne(@RequestParam("agencyid") String agencyId){
        return ResultVOUtil.success(agencyService.findOne(agencyId));
    }

    @PostMapping("/save")
    public ResultVO save(@RequestBody Agency agency){
        System.out.println(agency);
        agencyService.save(agency);
        return ResultVOUtil.success();
    }

    @PostMapping("/update")
    public ResultVO update(@RequestParam("agencyid") String agencyId, @RequestBody Agency agency){
        agencyService.update(agencyId,agency);
        return ResultVOUtil.success();
    }

    @PostMapping("/delete")
    public ResultVO delete(@RequestParam("agencyid") String agencyId){
        agencyService.delete(agencyId);
        return ResultVOUtil.success();
    }

    @PostMapping("/findbynumber")
    public ResultVO findByNumber(String number){
        return ResultVOUtil.success(agencyService.findByNumber(number));
    }

}
