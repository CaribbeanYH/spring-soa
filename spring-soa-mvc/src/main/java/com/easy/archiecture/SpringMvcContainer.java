package com.easy.archiecture;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.startup.Tomcat;

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
        // 注册listener
        context.addLifecycleListener((LifecycleListener) Class.forName(tomcat.getHost().getConfigClass()).newInstance());
        tomcat.start();
        tomcat.getServer().await();
    }
}
