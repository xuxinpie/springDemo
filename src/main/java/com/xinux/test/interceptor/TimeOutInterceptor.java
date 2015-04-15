package com.xinux.test.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xinux.test.controller.TestController;

public class TimeOutInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    private int                 beginWrk;
    private int                 endWrk;
    private String              redirectUrl;

    //利用拦截器判断时间是否从凌晨1点中午12点
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        logger.info("TimeOutinterceptor", "I am in Custom Interceptor");
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour > beginWrk && hour < endWrk) {
            return true;
        } else {
            response.sendRedirect(redirectUrl);
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("after postHandler");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("after completion");
    }

    public int getBeginWrk() {
        return beginWrk;
    }

    public void setBeginWrk(int beginWrk) {
        this.beginWrk = beginWrk;
    }

    public int getEndWrk() {
        return endWrk;
    }

    public void setEndWrk(int endWrk) {
        this.endWrk = endWrk;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

}
