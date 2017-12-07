package com.boot.common.filter;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by xianchun.hu on 12/7/2017.
 * @Order 表示过滤器质性顺序，数字小的先执行
 */
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
@Order(2)
public class LoginFilter implements Filter {

    private static Logger LOG = Logger.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("loginFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOG.info("loginFilter doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        LOG.info("loginFilter destory");
    }
}
