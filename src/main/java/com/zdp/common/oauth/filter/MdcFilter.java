package com.zdp.common.oauth.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

/**
 * @author <a href="mailto:zhoudapeng8888@126.com">zhoudapeng</a>
 * Date 2018/6/14
 * Time 下午1:23
 */
@Component
@Order(1)
@WebFilter(urlPatterns = "/*", filterName = "mdcFilter")
public class MdcFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(MdcFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init MdcFilter...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MDC.put("TRACE_ID", UUID.randomUUID().toString());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        logger.info("destroy MdcFilter...");
    }
}
