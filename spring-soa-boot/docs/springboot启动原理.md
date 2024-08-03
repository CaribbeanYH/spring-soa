```text


先初始化--spring容器--》初始化MVC DispatchServlet -》启动tomcat

1、org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration
2、org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext

// 在刷新Spring IoC容器的过程中会调用该方法
@Override
protected void onRefresh() {
    super.onRefresh();
    try {
        createWebServer();
    }
    catch (Throwable ex) {
        throw new ApplicationContextException("Unable to start web server", ex);
    }
}
 
private void createWebServer() {
    // 在这里会完成对Servlet容器的创建，并且与ServletContext上下文进行关联
}

org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext#selfInitialize
private void selfInitialize(ServletContext servletContext) throws ServletException {
	// <202106061603>
	prepareWebApplicationContext(servletContext);
	// 忽略
	registerApplicationScope(servletContext);
	// 忽略
	WebApplicationContextUtils.registerEnvironmentBeans(getBeanFactory(), servletContext);
	// 逐个调用ServletContextInitializer，比如DispatcherServlet
	// 的注册就是通过这里的方法调用完成的，这个我们在"3：springboot如何使用servlet"
	// 已经分析过了
	for (ServletContextInitializer beans : getServletContextInitializerBeans()) {
		beans.onStartup(servletContext);
	}
}
3、org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
4、org.springframework.boot.web.embedded.tomcat.TomcatWebServer
   org.springframework.boot.web.embedded.netty.NettyWebServer
   org.springframework.boot.web.embedded.jetty.JettyWebServer   

```