package com.yaoxinjia.filter;

import com.yaoxinjia.entity.Admin;
import com.yaoxinjia.entity.Reader;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author shkstart
 * @date 2020/3/3 0003 - 下午 6:48
 */
@WebFilter("*.jsp")
public class jspFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        Reader reader = (Reader)session.getAttribute("reader");
        if (admin == null || reader == null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else{
            chain.doFilter(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}