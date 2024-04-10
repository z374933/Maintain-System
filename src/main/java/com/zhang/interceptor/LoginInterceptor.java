package com.zhang.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

//用户登录拦截器
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录逻辑
        HttpSession session = request.getSession();
        Object id = session.getAttribute("id");
        if (id != null) {
            return true;//放行
        }
        response.sendRedirect("/page/login.html");
        return false;
    }
}
