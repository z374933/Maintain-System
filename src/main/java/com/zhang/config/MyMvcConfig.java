package com.zhang.config;

import com.zhang.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//拦截所以请求
                .excludePathPatterns("/user/login", "/user/addUser", "/api/**", "/css/**", "/images/**", "/js/**", "/lib/**", "/page/**");//放行资源
    }

}
