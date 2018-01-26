package com.example.manager_house_88.authwechat;

import com.alibaba.fastjson.JSON;
import com.example.manager_house_88.domain.User;
import com.example.manager_house_88.exception.ManagerHouse88Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class WechatMiniAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        WechatMiniAuthenticationToken authenticationToken = (WechatMiniAuthenticationToken) authentication;
        String code = (String) authenticationToken.getPrincipal();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx80684f34298ce2d7&secret=a73ba9a5f6d09d9e7d698ab8ee213b78&js_code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(url, String.class);
        Map map = (Map) JSON.parse(jsonData);
        String openid = (String) map.get("openid");
        if (openid == null) {
            throw new ManagerHouse88Exception("Unable to obtain open information");
        }
        WechatMiniUserinfo userinfo = new WechatMiniUserinfo();
        String userId = userinfo.getId(openid);

        WechatMiniAuthenticationToken authenticationResult = new WechatMiniAuthenticationToken(userId,true);
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return WechatMiniAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
