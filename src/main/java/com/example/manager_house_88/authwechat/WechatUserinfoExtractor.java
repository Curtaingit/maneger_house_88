package com.example.manager_house_88.authwechat;

import com.example.manager_house_88.domain.User;
import com.example.manager_house_88.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by cx on 17-12-29.
 */
@Component
public class WechatUserinfoExtractor implements PrincipalExtractor {

    @Autowired
    private UserService userService;

    @Override
    public Object extractPrincipal(Map<String, Object> map) {


        String openid = (String)map.get("openid");
        if (userService.findByOpenid(openid)==null){
            User user =new User();
            user.setName((String)map.get("nickname"));
            user.setOpenid(openid);
            user.setGender((map.get("sex").toString()));
            user.setCity((String)(map.get("city")));
            user.setProvince((String)(map.get("province")));
            user.setCountry((String)(map.get("country")));
            user.setHeadImgUrl((String)map.get("headimgurl"));
            userService.save(user);
        }

        return openid;
    }
}
