package com.boot.common.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by xianchun.hu on 12/7/2017.
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    private static Logger LOG = Logger.getLogger(MyServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOG.info("servlet context init");
        LOG.info(servletContextEvent.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOG.info("serlvet context destory");
    }
}
