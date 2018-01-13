package com.example.manager_house_88.controller;

import com.ctc.wstx.util.URLUtil;
import com.example.manager_house_88.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("wechat")
public class WeChatMiniController {

    @PostMapping("/auth")
    public String auth(String code){

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx80684f34298ce2d7&secret=a73ba9a5f6d09d9e7d698ab8ee213b78&js_code='"+ code +"'&grant_type=authorization_code";

        return "redirect:" + url;
    }
}
