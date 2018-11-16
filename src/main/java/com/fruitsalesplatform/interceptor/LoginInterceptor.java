package com.fruitsalesplatform.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dukunpeng
 * @date 2018/11/9 10:42
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url= httpServletRequest.getRequestURI();
        System.out.println(url);

        if (!(url.contains("Login")||url.contains("login")||url.contains("register"))){
            //非登录请求
            if (httpServletRequest.getSession().getAttribute("user")!=null){
                //如果已经登录过
                return true;
            }else {
                //如果没登录过，且样式类的请求
                if (url.contains("css")||url.contains("js")||url.contains("images")||url.contains("Demo")){
                    return true;
                }else {
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/user/toLogin.action");
                }
            }
        }else {
            //登录请求，放行
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
