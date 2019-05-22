package com.dunzung.ssm.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public final class SafeContextLoaderListener implements ServletContextListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static final String CAUGHT_THROWABLE_KEY = "exceptionCaughtByListener";

    private final ContextLoaderListener delegate = new ContextLoaderListener();

    public void contextInitialized(final ServletContextEvent sce) {
        try {
            this.delegate.contextInitialized(sce);
        } catch (final Throwable t) {
            final String message = "SafeContextLoaderListener: \n"
                + "The Spring ContextLoaderListener we wrap threw on contextInitialized.\n"
                + "But for our having caught this error, the web application context would not have initialized.";
            logger.error(message, t);
            ServletContext context = sce.getServletContext();
            context.log(message, t);
            context.setAttribute(CAUGHT_THROWABLE_KEY, t);
        }
    }

    public void contextDestroyed(final ServletContextEvent sce) {
        this.delegate.contextDestroyed(sce);
    }

}
