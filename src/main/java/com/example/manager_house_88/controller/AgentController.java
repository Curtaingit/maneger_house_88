package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Agent;
import com.example.manager_house_88.service.AgentService;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @RequestMapping("/findall")
    public ResultVO findAll(@RequestParam(name = "sort", defaultValue = "level") String sort){
        List<Agent> agentList = agentService.findAll(new Sort(Sort.Direction.DESC,sort));
        return ResultVOUtil.success(agentList);
    }

    @PostMapping("/findone")
    public ResultVO findOne(@RequestParam("agentid") String agentId){
        return ResultVOUtil.success(agentService.findOne(agentId));
    }

    @PostMapping("/save")
    public ResultVO save(@RequestBody Agent agent){
        agentService.save(agent);
        return ResultVOUtil.success();
    }

    @PostMapping("/update")
    public ResultVO update(@RequestParam("agentid") String agentId, @RequestBody Agent agent){
        agentService.update(agentId,agent);
        return ResultVOUtil.success();
    }

    @PostMapping("/delete")
    public ResultVO delete(@RequestParam("agentid") String agentId){
        agentService.delete(agentId);
        return ResultVOUtil.success();
    }
    @PostMapping("/findbynumber")
    public ResultVO findByNumber(String number){
        return ResultVOUtil.success(agentService.findByNumber(number));
    }

}
