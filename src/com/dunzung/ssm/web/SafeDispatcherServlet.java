package com.dunzung.ssm.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextException;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public final class SafeDispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public static final String CAUGHT_THROWABLE_KEY = "exceptionCaughtByServlet";

    private static final Logger LOGGER = LoggerFactory.getLogger(SafeDispatcherServlet.class);

    private DispatcherServlet delegate = new DispatcherServlet();

    private boolean initSuccess = true;

    public void init(final ServletConfig config) {
        try {
            this.delegate.init(config);
        } catch (final Throwable t) {
            this.initSuccess = false;
            final String message = "SafeDispatcherServlet: \n"
                    + "The Spring DispatcherServlet we wrap threw on init.\n"
                    + "But for our having caught this error, the servlet would not have initialized.";
            LOGGER.error(message, t);
            ServletContext context = config.getServletContext();
            context.log(message, t);
            context.setAttribute(CAUGHT_THROWABLE_KEY, t);

        }
    }

    @Override
    public void service(final ServletRequest req, final ServletResponse resp) throws ServletException, IOException {
        if (this.initSuccess) {
            this.delegate.service(req, resp);
        } else {
            throw new ApplicationContextException("Unable to initialize application context.");
        }
    }

}
