package com.yaoxinjia.filter;

import com.yaoxinjia.entity.Reader;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author shkstart
 * @date 2020/2/18 0018 - 下午 4:03
 */
@WebFilter("/book")
public class ReaderFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        Reader reader =(Reader)session.getAttribute("reader");
        if(reader == null){
            ((HttpServletResponse)servletResponse).sendRedirect("/login.jsp");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
