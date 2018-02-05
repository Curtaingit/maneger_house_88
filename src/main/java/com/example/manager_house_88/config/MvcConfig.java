package com.example.manager_house_88.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Value("${imagepath}")
    String imagepath;

    @Value("${videopath}")
    String videopath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+imagepath);
        registry.addResourceHandler("/").addResourceLocations("https://www.baidu.com");
        registry.addResourceHandler("/video/**").addResourceLocations("file:"+ videopath);
    }


}
