package com.jk.config;

import com.jk.user.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");
        User user = (User) request.getSession().getAttribute("request.getSession().getId()");
        System.err.println(user);
        System.err.println(121212121);
        if (user != null) {
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/index");
        return false;
    }
}