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
public class SpringMvcBoot {
    public static void main(String[] args) throws Exception {
        // 内置tomcat
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.getInteger("port", 8080));
        tomcat.getConnector();
        String webAppContextPath = new File("spring-soa-mvc-boot/src/main/webapp").getAbsolutePath();
        Context context = tomcat.addWebapp("/", webAppContextPath);
        WebResourceRoot resources = new StandardRoot(context);
        File additionWebInfClasses = new File("spring-soa-mvc-boot/target/classes");
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
        context.setResources(resources);
        tomcat.start();
        // 服务阻塞等待
        tomcat.getServer().await();
    }

    /**
     * addContext()与addWebapp()这两种方法都是向嵌入式tomcat添加web应用程序。
     *
     * addContext()需要配置相关所有内容，比如配置默认的Servlet，否则将无法访问静态资源。
     *
     * addWebapp()可以理解为拥有自动配置功能，同时我们也可以通过次方法添加Servlet，指定静态资源路径
     */
}
