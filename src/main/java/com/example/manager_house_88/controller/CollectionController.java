package com.example.manager_house_88.controller;

import com.example.manager_house_88.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/collection")
@RestController
@CrossOrigin(origins = {},methods ={RequestMethod.GET,RequestMethod.POST, RequestMethod.OPTIONS})
public class CollectionController  {

    @Autowired
    private CollectionService collectionService;

//    @PostMapping("/save")
//    public Object save(Principal principal, @RequestParam("commodityid") String commodityId){
//        collectionService.save(principal.getName(),commodityId);
//        return "操作成功!";
//    }


    //userid方法
    @PostMapping("/save")
    public Object save(@RequestParam("userid") String userId, @RequestParam("commodityid") String commodityId){
        collectionService.save(userId,commodityId);
        return "操作成功!";
    }


    @PostMapping("/delete")
    public Object delete(@RequestParam("collectionid") String collectionId){
        collectionService.delete(collectionId);
        return "操作成功!";
    }

    @PostMapping("/getcommodities")
    public Object getCommodities(Principal principal){
      return collectionService.getCommodities(principal.getName());
    }
}
