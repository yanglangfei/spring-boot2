package com.yanglf.mvc.filter;

import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

/**
 * @author yanglf
 * @sine 2019.08.01
 * @descriptipon
 * @see
 */
@WebFilter(filterName = "requestFilter", urlPatterns = "/*")
public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter----------------");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
