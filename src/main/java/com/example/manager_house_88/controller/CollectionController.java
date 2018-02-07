package com.example.manager_house_88.controller;

import com.example.manager_house_88.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;

@RequestMapping("/collection")
@RestController
@CrossOrigin(origins = {},methods ={RequestMethod.GET,RequestMethod.POST, RequestMethod.OPTIONS})
public class CollectionController  {

    @Autowired
    private CollectionService collectionService;


    //userid     K
    @PostMapping("/save")
    public Object save(Principal principal, @RequestParam("commodityid") String commodityId,@RequestParam(name="userid",required = false) String userId){
        collectionService.save(principal.getName(),commodityId);
        return "操作成功!";
    }

    //userid     K
    @PostMapping("/delete")
    public Object delete(Principal principal,@RequestParam("commodityid") String commodityId,@RequestParam(name = "userid",required = false) String userId){
        collectionService.delete(principal.getName(),commodityId);
        return "操作成功!";
    }

    //userid     K
    @PostMapping("/getcommodities")
    public Object getCommodities(Principal principal,@RequestParam(name = "userid",required = false) String userId){
      return collectionService.getCommodities(principal.getName());
    }
}
