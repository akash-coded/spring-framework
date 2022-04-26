package com.spring.boot.logging.demo.registries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.boot.logging.demo.interceptors.IPAddressInterceptor;
 
@Component
public class InterceptorRegistry implements WebMvcConfigurer {
    @Autowired
    private IPAddressInterceptor ipAddressInterceptor;
    
    @Override
    public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
        registry.addInterceptor(ipAddressInterceptor);
    }
}
