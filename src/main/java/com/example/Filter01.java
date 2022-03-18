package com.example;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

//*拦截所有
@WebFilter("/*")
public class Filter01 implements Filter {
    //private String encode = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter01 init...");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //把爸爸转型成儿子的类，从而获得儿子里面特有的方法｛HttpServletRequest是儿子，ServletRequest是爸爸｝
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //添加放行页面，无需登陆也能访问
        String uri = httpServletRequest.getRequestURI();
        if (uri.contains("login.jsp") || uri.contains("login") || httpServletRequest.getSession().getAttribute("user") != null ){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        //放行静态资源
        httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, httpServletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
