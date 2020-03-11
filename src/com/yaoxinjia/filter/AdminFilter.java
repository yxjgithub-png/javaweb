package com.yaoxinjia.filter;

import com.yaoxinjia.entity.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author shkstart
 * @date 2020/2/19 0019 - 下午 12:52
 */
@WebFilter("/admin")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        if (admin == null){
            response.sendRedirect("login.jsp");
        }else{
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
