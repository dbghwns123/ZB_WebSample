package org.example.websample.config;


import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
//@Component
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        // 외부 -> filter {-> 처리(Controller) ->} filter -> 외부
        log.info("Hello LogFilter: " + Thread.currentThread());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("Bye LogFilter: " + Thread.currentThread());
    }
}
