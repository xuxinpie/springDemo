package com.xinux.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 登录检测拦截器，根据session中是否有User消，避免重复登录
 * 
 * @author hanlin.xx
 * @version $Id: CheckLoginInterceptor.java, v 0.1 2015-4-15 下午4:36:56 hanlin.xx Exp $
 */
public class CheckLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        if (null == request.getSession().getAttribute("user")) {
            return true;
        } else {
            response.sendRedirect("homePage");
            return true;
        }
        /*System.out.println(request.getServletPath()); //print /UserController/login
          System.out.println(request.getContextPath()); //print /springDemo
        */

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }

}
