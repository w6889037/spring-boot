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
@WebFilter(filterName = "encodingFilter", urlPatterns = "/*")
@Order(1)
public class EncodingFilter implements Filter {

    private static Logger LOG = Logger.getLogger(EncodingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("encodingFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOG.info("encodingFilter doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        LOG.info("encodingFilter destory");
    }
}
