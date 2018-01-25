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
    private WxMpService wxMpService;

    @GetMapping(value="/jsapisignature")
    @ResponseBody
    public Object createJsapiSignature(@RequestParam("url") String url) throws WxErrorException {
        return this.wxMpService.createJsapiSignature(url);
    }


}
