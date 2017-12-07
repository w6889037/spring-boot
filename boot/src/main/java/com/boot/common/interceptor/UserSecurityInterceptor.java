package com.boot.common.interceptor;

import com.boot.user.model.User;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xianchun.hu on 12/7/2017.
 */
public class UserSecurityInterceptor implements HandlerInterceptor {

    private static Logger LOG = Logger.getLogger(UserSecurityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object obj = httpServletRequest.getSession().getAttribute("user");
        LOG.info("user security interceptor");
        if(obj == null && obj instanceof User){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/home");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
