package com.example.manager_house_88.controller;


import com.example.manager_house_88.domain.CustomerManager;
import com.example.manager_house_88.service.CustomerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = {},methods ={RequestMethod.GET,RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping("/customermanager")
@RestController
public class CustomerManagerController {

    @Autowired
    private CustomerManagerService customerManagerService;

    @PostMapping("/save")
    public Object save(@RequestBody CustomerManager customerManager){
       return customerManagerService.save(customerManager);
    }

    @PostMapping("/delete")
    public Object delete (@RequestParam("customermanagerid") String customerManagerId){
        customerManagerService.delete(customerManagerId);
        return null;
    }

    @RequestMapping("/findall")
    public Object findAll(){
        return customerManagerService.findAll();
    }


    @PostMapping("/findone")
    public Object findone(@RequestParam("customermanagerid") String customerManagerId){
        return customerManagerService.findOne(customerManagerId);
    }

    @PostMapping("/update")
    public Object update(@RequestParam("customermanagerid") String customerManagerId,
                         @RequestBody CustomerManager customerManager){
        return customerManagerService.update(customerManagerId,customerManager);
    }
}
