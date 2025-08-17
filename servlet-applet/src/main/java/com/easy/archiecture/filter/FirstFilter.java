package com.easy.archiecture.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2025/8/17 11:13
 */
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("init");
    }

    //http://example.com/page.php?param=<?php system($_GET['cmd']); ?>

    //http://example.com/page.php?param=null

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //
        System.out.println("放行前");
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        //获取当前请求的URL
        System.out.println(httpServletRequest.getRequestURL());
        //放行，调用下一个过滤器或者访问资源
        chain.doFilter(request, response);
        System.out.println("放行后");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
