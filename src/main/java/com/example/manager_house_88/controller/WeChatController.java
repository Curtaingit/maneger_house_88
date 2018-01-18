package com.example.manager_house_88.controller;

import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin(origins = {},methods ={RequestMethod.GET,RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping("/wechat")
public class WeChatController {

    @Autowired
    WxMpService wxMpService;

//    @PostMapping("/auth")
//    public String auth(String code){
//
//        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx80684f34298ce2d7&secret=a73ba9a5f6d09d9e7d698ab8ee213b78&js_code='"+ code +"'&grant_type=authorization_code";
//
//        return "redirect:" + url;
//    }

    @GetMapping(value="/jsapisignature")
    @ResponseBody
    public WxJsapiSignature createJsapiSignature(@RequestParam("url") String url) throws WxErrorException {
        //return this.wxMpService.createJsapiSignature(url);
   return null ;
    }
}
