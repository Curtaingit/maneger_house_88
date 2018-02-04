package com.example.manager_house_88.authwechat;

import com.example.manager_house_88.domain.User;
import com.example.manager_house_88.repository.UserRepo;
import com.example.manager_house_88.service.CommodityService;
import com.example.manager_house_88.service.UserService;
import com.example.manager_house_88.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by cx on 17-12-29.
 */

public class WechatMiniUserInfo {

    public String getId(String openid) {
        UserService userService = (UserService) SpringUtil.getBean("userService");
     //   CommodityService commodityService = (CommodityService) SpringUtil.getBean("CommodityService");
        User user;
        user = userService.findByOpenid(openid);
        if (user == null) {
            User rs = new User();
            rs.setOpenid(openid);
            User save = userService.save(rs);
            return save.getId();
        }
        return user.getId();
    }
}