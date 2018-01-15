package com.example.manager_house_88.authwechat;

import com.fasterxml.jackson.databind.JavaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class WeixinOAuth2RestTemplate extends OAuth2RestTemplate {

    public WeixinOAuth2RestTemplate(AuthorizationCodeResourceDetails resource, OAuth2ClientContext context ,String hendlerurl) {
        super(resource, context);
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new MappingJackson2HttpMessageConverter() {



            @Override
            protected boolean canRead(MediaType mediaType) {
                return true;
            }

            @Override
            public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage)
                    throws IOException, HttpMessageNotReadableException {
                BufferedReader br=new BufferedReader(new InputStreamReader(inputMessage.getBody(),"utf-8"));
                String temp=br.readLine();
                final String tokenstr=temp.replace("session_key","access_token");
                //TODO 观察微信公众号获取accesstoken时此处的结果,s修改成相同的格式

                     return super.read(type,contextClass,
                         new HttpInputMessage(){

                             @Override
                             public HttpHeaders getHeaders() {
                                 throw new RuntimeException("not yet  implemented!");
                             }

                             @Override
                             public InputStream getBody() throws IOException {
                                 return new ByteArrayInputStream(tokenstr.getBytes("utf-8"));
                             }
                         });

            }

        });
        this.setMessageConverters(messageConverters);
        this.setAccessTokenProvider(new WeixinAuthorizationCodeAccessTokenProvider(messageConverters,hendlerurl));
    }

    @Override
    protected URI appendQueryParameter(URI uri, OAuth2AccessToken accessToken) {
        uri = super.appendQueryParameter(uri, accessToken);
        String url = uri.toString();
        if (url.contains("$openid$")) {
            String openid = (String) accessToken.getAdditionalInformation().get("openid");
            try {

                uri = new URI(url.replace("$openid$", openid));

            } catch (URISyntaxException e) {

                e.printStackTrace();

            }
        }
        return uri;

    }
}


