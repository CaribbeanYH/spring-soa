package com.easy.archiecture;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/28 19:09
 */
@SuppressWarnings("ALL")
public class SpringMvcContainer {
    public static void main(String[] args) throws Exception {
        // 内置tomcat
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.getInteger("port", 8080));
        tomcat.getConnector();
        Context context = tomcat.addContext("/", System.getProperty("java.io.tmpdir"));
//        Context context = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
//        WebResourceRoot resources = new StandardRoot(context);
//        resources.addPreResources(
//                new DirResourceSet(resources, "/WEB-INF/classes", new File("spring-mvc/target/classes").getAbsolutePath(), "/"));
//        context.setResources(resources);
        // 注册listener
        context.addLifecycleListener((LifecycleListener) Class.forName(tomcat.getHost().getConfigClass()).newInstance());
        tomcat.start();
        tomcat.getServer().await();
    }
}
