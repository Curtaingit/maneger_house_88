package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Agency;
import com.example.manager_house_88.service.AgencyService;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @RequestMapping("/findall")
    public ResultVO findAll(@RequestParam(name = "sort", defaultValue = "level") String sort){
        List<Agency> agencyList = agencyService.findAll(new Sort(Sort.Direction.DESC,sort));
        return ResultVOUtil.success(agencyList);
    }

    @PostMapping("/findone")
    public ResultVO findOne(@RequestParam("agencyId") String agencyId){
        return ResultVOUtil.success(agencyService.findOne(agencyId));
    }

    @PostMapping("/add")
    public ResultVO add(@RequestBody Agency agency){
        agencyService.add(agency);
        return ResultVOUtil.success();
    }

    @PostMapping("/update")
    public ResultVO update(@RequestParam("agencyId") String agencyId, @RequestBody Agency agency){
        agencyService.update(agencyId,agency);
        return ResultVOUtil.success();
    }

    @PostMapping("/delete")
    public ResultVO delete(@RequestParam("agencyId") String agencyId){
        agencyService.delete(agencyId);
        return ResultVOUtil.success();
    }



}