package com.example.manager_house_88.authwechat;


import com.alibaba.fastjson.JSON;
import com.example.manager_house_88.domain.User;
import com.example.manager_house_88.exception.ManagerHouse88Exception;
import com.example.manager_house_88.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WechatMiniAuthenticationFilter extends AbstractAuthenticationProcessingFilter {


    public static final String SPRING_SECURITY_FORM_CODE_KEY = "code";

    private String codeParameter = SPRING_SECURITY_FORM_CODE_KEY;


    private boolean postOnly = true;

    public WechatMiniAuthenticationFilter() {
        super(new AntPathRequestMatcher("/wechatmini/login", "POST"));
    }

    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }


        String code = obtainCode(request);

        if (code == null) {
            code = "";
        }

        code = code.trim();

        WechatMiniAuthenticationToken authRequest = new WechatMiniAuthenticationToken(code, false);

        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);


    }


    protected String obtainCode(HttpServletRequest request) {
        return request.getParameter(codeParameter);
    }


    protected void setDetails(HttpServletRequest request,
                              WechatMiniAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    /**
     * Sets the parameter name which will be used to obtain the username from the login
     * request.
     *
     * @param codeParameter the parameter name. Defaults to "username".
     */
    public void setCodeParameter(String codeParameter) {
        Assert.hasText(codeParameter, "code parameter must not be empty or null");
        this.codeParameter = codeParameter;
    }


    /**
     * Defines whether only HTTP POST requests will be allowed by this filter. If set to
     * true, and an authentication request is received which is not a POST request, an
     * exception will be raised immediately and authentication will not be attempted. The
     * <tt>unsuccessfulAuthentication()</tt> method will be called as if handling a failed
     * authentication.
     * <p>
     * Defaults to <tt>true</tt> but may be overridden by subclasses.
     */
    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String codeParameter() {
        return codeParameter;
    }

}
