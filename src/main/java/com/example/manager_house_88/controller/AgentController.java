package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Agent;
import com.example.manager_house_88.service.AgentService;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @RequestMapping("/findall")
    public Object findAll(@RequestParam(name = "sort",defaultValue = "createtime") String sortName,
                            @RequestParam(name="size",required = false) Integer size,
                            @RequestParam(name = "page",required = false) Integer page){
        Sort sort =new Sort(Sort.Direction.DESC,sortName);
        if(size==null||page==null){
            return  agentService.findAll(sort);
        }
        Pageable pageable =new PageRequest(page-1,size,sort);
        return agentService.findAll(pageable);
    }

    @PostMapping("/findone")
    public Object findOne(@RequestParam("agentid") String agentId){
        return agentService.findOne(agentId);
    }

    @PostMapping("/save")
    public void save(@RequestBody Agent agent){
        agentService.save(agent);
    }

    @PostMapping("/update")
    public void update(@RequestParam("agentid") String agentId, @RequestBody Agent agent){
        agentService.update(agentId,agent);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam("agentid") String agentId){
        agentService.delete(agentId);
    }
    @PostMapping("/findbynumber")
    public Object findByNumber(String number){
        return agentService.findByNumber(number);
    }

}
