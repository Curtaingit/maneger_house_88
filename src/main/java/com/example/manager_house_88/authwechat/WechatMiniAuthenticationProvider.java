package com.example.manager_house_88.authwechat;

import com.alibaba.fastjson.JSON;
import com.example.manager_house_88.exception.ManagerHouse88Exception;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class WechatMiniAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        WechatMiniAuthenticationToken authenticationToken = (WechatMiniAuthenticationToken) authentication;
        String code = (String) authenticationToken.getPrincipal();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx007de3f944b85ec6&secret=32d982af1871c587dddd7caa92d9e89e&js_code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(url, String.class);
        Map map = (Map) JSON.parse(jsonData);
        String openid = (String) map.get("openid");
        if (openid == null) {
            throw new BadCredentialsException("Unable to obtain open information");
        }
        WechatMiniUserInfo userInfo = new WechatMiniUserInfo();
        String userId = userInfo.getId(openid);

        WechatMiniAuthenticationToken authenticationResult = new WechatMiniAuthenticationToken(userId,true);
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return WechatMiniAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
