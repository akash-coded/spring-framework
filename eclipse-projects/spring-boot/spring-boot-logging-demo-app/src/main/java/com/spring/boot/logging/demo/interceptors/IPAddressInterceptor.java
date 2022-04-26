package com.spring.boot.logging.demo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class IPAddressInterceptor implements HandlerInterceptor {
	private static final Logger log = LoggerFactory.getLogger(IPAddressInterceptor.class);

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ipAddress = request.getHeader("X-Forward-For");
 
        if(ipAddress== null){
 
            ipAddress = request.getRemoteAddr();
        }
 
        log.info("Incoming request from " + ipAddress);
        
        return true;
    }
	
}
