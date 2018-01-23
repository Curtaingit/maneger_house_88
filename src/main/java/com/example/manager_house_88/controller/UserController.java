package com.example.manager_house_88.controller;


import com.example.manager_house_88.service.UserService;
import com.example.manager_house_88.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {},methods ={RequestMethod.GET,RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping("/document")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findall")
    public Object findAll(@RequestParam(name = "sort",defaultValue = "createtime") String sortName,
                          @RequestParam(name="size",required = false) Integer size,
                          @RequestParam(name = "page",required = false) Integer page){
        Sort sort =new Sort(Sort.Direction.DESC,sortName);
        if(size==null||page==null){
            return    userService.findAll(sort);
        }
        Pageable pageable =new PageRequest(page-1,size,sort);
        return userService.findAll(pageable);

    }


}
