package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.domain.Schedule;
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
@CrossOrigin(origins = {},methods ={RequestMethod.GET,RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping("/commodity")
@RestController
public class CommodityController {


    @Autowired
    private CommodityService commodityService;

    @PostMapping("/findone")
    public Object findOne(@RequestParam(name = "commodityid") String commodityId) {
        return commodityService.findOne(commodityId);
    }


    @RequestMapping("/findall")
    public Object findAll(@RequestParam(name = "sort", defaultValue = "createtime") String sortName,
                          @RequestParam(name = "size", required = false) Integer size,
                          @RequestParam(name = "page", required = false) Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, sortName);
        if (size == null || page == null) {
            return commodityService.findAll(sort);
        }
        Pageable pageable = new PageRequest(page - 1, size, sort);
        return commodityService.findAll(pageable);
    }

    @PostMapping("/save")
    public Object save(@RequestBody Commodity commodity) {
        return commodityService.save(commodity);
    }

    @PostMapping("/findbystatus")
    public Object findbystatus(String status) {
        return commodityService.findByStatus(status);
    }

    @PostMapping("/delete")
    public Object delete(@RequestParam(name = "commodityid") String commodityId) {
        commodityService.delete(commodityId);
        return "操作成功";
    }

    @PostMapping("/setdetail")
    public Object setDetail(@RequestParam(name = "commodityid") String commodityId, @RequestBody String detail) {
        commodityService.setDetail(commodityId, detail);
        return "操作成功";
    }

    @PostMapping("/getdetail")
    public Object getDetail(@RequestParam(name = "commodityid",required = false) String commodityId) {

        return commodityService.getDetail(commodityId);
    }

    @PostMapping("/update")
    public Object update(@RequestParam(name = "commodityid") String commodityId,
                         @RequestBody Commodity commodity) {
        return commodityService.update(commodityId, commodity);
    }

    @PostMapping("/changestate")
    public Object changeState(@RequestParam(name = "commodityid") String commodityId,@RequestParam("state") int state){
        commodityService.changeState(commodityId,state);
        return "操作成功";
    }


    @PostMapping("/changestatus")
    public Object changeStatus(@RequestParam(name = "commodityid") String commodityId,@RequestParam("status") int status){
        commodityService.changeStatus(commodityId,status);
        return "操作成功";
    }

    @PostMapping("/findbynumber")
    public Object findByNumber(String number){
        return commodityService.findByNumber(number);
    }




}