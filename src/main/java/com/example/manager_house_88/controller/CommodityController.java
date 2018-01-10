package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.service.CommodityService;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cx on 18-1-10.
 */

@RequestMapping("/commodity")
@RestController
public class CommodityController {


    @Autowired
    private CommodityService commodityService;

    @PostMapping("/findone")
    public ResultVO findOne(@RequestParam(name="commodityid") String commodityId){
       return ResultVOUtil.success(commodityService.findOne(commodityId));
    }


    @GetMapping("/findall")
    public ResultVO findAll(@RequestParam(name = "sort",defaultValue = "createtime") String sortName){
        Sort sort =new Sort(Sort.Direction.DESC,sortName);
        return ResultVOUtil.success(commodityService.findAll(sort)) ;
    }


}
