package com.example.manager_house_88.authwechat;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.resource.UserApprovalRequiredException;
import org.springframework.security.oauth2.client.resource.UserRedirectRequiredException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class WechatOAuth2ClientAuthenticationProcessingFilter extends OAuth2ClientAuthenticationProcessingFilter {

    public WechatOAuth2ClientAuthenticationProcessingFilter(String path) {
        super(path);
        ((SavedRequestAwareAuthenticationSuccessHandler)this.getSuccessHandler()).setTargetUrlParameter("state");

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        try {
            super.doFilter(req, res, chain);
        } catch (UserApprovalRequiredException ex) {
            throw ex;
        } catch (UserRedirectRequiredException ex2) {
            throw ex2;
        } catch (Exception e) {

            e.printStackTrace();
            this.unsuccessfulAuthentication((HttpServletRequest) req, (HttpServletResponse) res, new AuthenticationException("不可描述之错误，请通知管理员！") {

            });
        }
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        return new OAuth2Authentication(new OAuth2Request(null,null,null,true,null,null,null,null,null), new Authentication() {

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return "asdf";
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return "XYZ";
            }

            @Override
            public boolean isAuthenticated() {
                return true;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return "abc";
            }
        });

    }
};