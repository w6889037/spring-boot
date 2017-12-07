package com.boot.common.listener;

import org.apache.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by xianchun.hu on 12/7/2017.
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    private static Logger LOG = Logger.getLogger(MyHttpSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOG.info("session init");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LOG.info("session destory");
    }
}
