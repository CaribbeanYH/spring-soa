package com.easy.archiecture.init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author yanghai
 * @ClassName
 * @Description
 * @date 2024/7/28 16:46
 */
public class EasyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.scan("com.easy.archiecture");
        servletContext.addListener(new ContextLoaderListener(webApplicationContext));
        ServletRegistration.Dynamic appServlet = servletContext.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }
}
