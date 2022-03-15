package com.example;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//*拦截所有
@WebFilter("/f01")
public class Filter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter01 init...");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filtering01...");
        //doFilter(servletRequest, servlet)不写的话，
        //相当于无法让请求到达servlet的业务处理
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println();
        System.out.println("f.... ");
    }
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
