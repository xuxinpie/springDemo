package com.xinux.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HandlerInterceptor1 extends HandlerInterceptorAdapter {

    //NamedThreadLocal：Spring提供的一个命名的ThreadLocal实现
    private final NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>(
                                                                  "StopWatch-StartTime");

    //处理器之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        System.out.println("===========HandlerInterceptor1 preHandle");
        long beginTime = System.currentTimeMillis();
        startTimeThreadLocal.set(beginTime);
        return true; //返回false则中断请求
    }

    //生成视图之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===========HandlerInterceptor1 postHandle");
    }

    //生成视图之后执行，表示一次请求执行结束
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("===========HandlerInterceptor1 afterCompletion");
        long endTime = System.currentTimeMillis();
        long beginTime = startTimeThreadLocal.get();
        long consumeTime = endTime - beginTime;
        //如果处理时间超过500ms的请求为慢请求
        if (consumeTime > 500) {
            System.out.println(String.format("%s consume %d millis", request.getRequestURI(),
                consumeTime));
        }
    }
}
