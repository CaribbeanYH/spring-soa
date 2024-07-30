package com.easy.archiecture.webApplication;

import com.easy.archiecture.config.AppConfig;
import com.easy.archiecture.fitler.CorsFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author yanghai10
 * @ClassName
 * @Description 这个类就是web.xml的替代品
 * @date 2024/7/30 10:29
 */
public class MvcBootWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
//       //Xml的形式
//        XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
//        webApplicationContext.setConfigLocation("classpath:spring-config.xml");
        //注解的形式
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(AppConfig.class);
        webApplicationContext.setServletContext(servletContext);
        // 创建 ContextLoaderListener
        // 用来管理 root WebApplicationContext 的生命周期：加载、初始化、销毁
        servletContext.addListener(new ContextLoaderListener(webApplicationContext));
        //添加过滤器
        servletContext.addFilter("corsFilter", new CorsFilter());
        // Creating a dispatcher servlet object
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
        // Registering Dispatcher Servlet with Servlet
        // Context
        ServletRegistration.Dynamic mvcDispatcherServlet = servletContext.addServlet("mvcDispatcherServlet", dispatcherServlet);
        // Setting load on startup
        mvcDispatcherServlet.setLoadOnStartup(1);
        // Adding mapping url
        mvcDispatcherServlet.addMapping("/");
    }
}
