package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.service.CommodityService;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping("/findall")
    public ResultVO findAll(@RequestParam(name = "sort",defaultValue = "createtime") String sortName,
                            @RequestParam(name="size",required = false) Integer size,
                            @RequestParam(name = "page",required = false) Integer page){
        Sort sort =new Sort(Sort.Direction.DESC,sortName);
        if(size==null||page==null){
            return  ResultVOUtil.success(commodityService.findAll(sort));
        }
        Pageable pageable =new PageRequest(page,size,sort);
        return ResultVOUtil.success(commodityService.findAll(pageable)) ;
    }

    @PostMapping("/save")
    public  ResultVO save(@RequestBody Commodity commodity){
        return ResultVOUtil.success(commodityService.save(commodity));
    }

    @PostMapping("/findbystatus")
    public ResultVO findbystatus(String status){
        return ResultVOUtil.success(commodityService.findByStatus(status));
    }
}
