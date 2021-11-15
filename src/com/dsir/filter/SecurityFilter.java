package com.dsir.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Project_Name 移通代sir
 * @Author Ww-Care
 * @Date 2021/11/15 15:03
 * @Version 1.0
 **/
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object username = request.getSession().getAttribute("username");
        if (username == null) {
            response.sendRedirect(request.getContextPath());
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
