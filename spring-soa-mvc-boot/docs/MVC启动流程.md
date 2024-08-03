1、org.springframework.web.SpringServletContainerInitializer

```java

@HandlesTypes(WebApplicationInitializer.class)
public class SpringServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(@Nullable Set<Class<?>> webAppInitializerClasses, ServletContext servletContext)
            throws ServletException {
        List<WebApplicationInitializer> initializers = new LinkedList<>();

        if (webAppInitializerClasses != null) {
            for (Class<?> waiClass : webAppInitializerClasses) {
                // Be defensive: Some servlet containers provide us with invalid classes,
                // no matter what @HandlesTypes says...
                if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) &&
                        WebApplicationInitializer.class.isAssignableFrom(waiClass)) {
                    try {
                        initializers.add((WebApplicationInitializer)
                                ReflectionUtils.accessibleConstructor(waiClass).newInstance());
                    } catch (Throwable ex) {
                        throw new ServletException("Failed to instantiate WebApplicationInitializer class", ex);
                    }
                }
            }
        }
        if (initializers.isEmpty()) {
            servletContext.log("No Spring WebApplicationInitializer types detected on classpath");
            return;
        }
        servletContext.log(initializers.size() + " Spring WebApplicationInitializers detected on classpath");
        AnnotationAwareOrderComparator.sort(initializers);
        for (WebApplicationInitializer initializer : initializers) {
            initializer.onStartup(servletContext);
        }
    }

}
```

2、创建ContextLoaderListener 和 DispatcherServlet 类似于web.xml

```java
//手动创建
public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        // 创建根容器
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        // 创建 ContextLoaderListener
        // 用来管理 root WebApplicationContext 的生命周期：加载、初始化、销毁
        container.addListener(new ContextLoaderListener(rootContext));

        // 创建 dispatcher 持有的上下文容器
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(DispatcherConfig.class);

        // 注册、配置 dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}

// 更简单的办法
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MyWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
```

3、SpringMVC 会通过 WebApplicationContext 来管理服务器请求中涉及到的各种对象和他们之间的依赖关系

```java
    public interface WebApplicationContext extends ApplicationContext {

    // 根容器名，作为 key 存储在 ServletContext 中; ServletContext 持有的 WebApplicationContext
    String ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE = WebApplicationContext.class.getName() + ".ROOT";

    /**
     * 这三个是 WebApplicationContext 特有的作用域
     * 通过 WebApplicationContextUtils.registerWebApplicationScopes 注册相应的处理器
     */
    String SCOPE_REQUEST = "request";
    String SCOPE_SESSION = "session";
    String SCOPE_APPLICATION = "application";

    /**
     * ServletContext 在 WebApplicationContext 中的名字
     * 通过 WebApplicationContextUtils.registerEnvironmentBeans 注册到 WebApplicationContext 中
     */
    String SERVLET_CONTEXT_BEAN_NAME = "servletContext";

    /**
     * ServletContext 和 ServletConfig 配置参数在 WebApplicationContext 中的名字
     * ServletConfig 的参数具有更高的优先级，会覆盖掉 ServletContext 中的参数
     * 值为 Map<String, String> 结构
     */
    String CONTEXT_PARAMETERS_BEAN_NAME = "contextParameters";

    /**
     * ServletContext 属性信息在 WebApplicationContext 中的名字
     * 值为 Map<String, String> 结构
     * 属性是用来描述 ServletContext 本身的一些信息的
     */
    String CONTEXT_ATTRIBUTES_BEAN_NAME = "contextAttributes";


    /**
     * 获取 ServletContext 接口
     */
    @Nullable
    ServletContext getServletContext();
}
```

3、WebApplicationContext 管理，包括业务方面的 @Controller, @Service, @Repository 注解的类， ServletContext, 文件处理 multipartResolver, 视图解析器 ViewResolver, 处理器映射器 HandleMapping，@AbstractApplicationContext#refresh
```java
@Override
public void refresh() throws BeansException, IllegalStateException {
synchronized (this.startupShutdownMonitor) {
        prepareRefresh();

        // XmlWebApplicationContext 和 AnnotationConfigWebApplicationContext 会在这里执行 refreshBeanFactory
        // 创建一个新的 DefaultListableBeanFactory 然后从 xml 或 java-config 配置中 loadBeanDefinitions
        ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

        prepareBeanFactory(beanFactory);

        try {
        // 在这里会配置一些 web 相关的东西，注册 web 相关的 scope
        postProcessBeanFactory(beanFactory);

        // 下面步骤和初始化其他 ApplicationContext 基本一致，忽略
        invokeBeanFactoryPostProcessors(beanFactory);
        registerBeanPostProcessors(beanFactory);
        initMessageSource();
        initApplicationEventMulticaster();
        onRefresh();
        registerListeners();
        finishBeanFactoryInitialization(beanFactory);
        finishRefresh();
        }

        catch (BeansException ex) {
        if (logger.isWarnEnabled()) {
        logger.warn("Exception encountered during context initialization - " +
        "cancelling refresh attempt: " + ex);
        }

        destroyBeans();
        cancelRefresh(ex);
        throw ex;
        }

        finally {
        resetCommonCaches();
        }
        }
        }

```
4、SpringMVC 通过两种方式创建 WebApplicationContext
```text
一种是通过 ContextLoaderListener, 它创建的 WebApplicationContext 称为 root application context，或者说根容器。一个 ServletContext 中只能有一个根容器，而一个 web application 中只能有一个 ServletContext，因此一个 web 应用程序中只能有一个根容器，根容器的作用和 ServletContext 类似，提供了一个全局的访问点，可以用于注册多个 servlet 共享的业务 bean。 根容器不是必要的。

另一种是通过 DispatcherServlet, 它创建的 WebApplicationContext，称为上下文容器，上下文容器只在 DispatcherServlet 范围内有效。DispatcherServlet 本质上是一个 Servlet，因此可以有多个 DispatcherServlet，也就可以有多个上下文容器。

如果上下文容器的 parent 为 null, 并且当前 ServletContext 中存在根容器，则把根容器设为他的父容器

```


5、ContextLoaderListener启动过程
```java
/**
 * ContextLoader#initWebApplicationContext
 */
public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
    // 当前 ServletContext 中是否已经存在 root web applicationContext
    // 一个 ServletContext 中只能有一个根容器
    if (servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE) != null) {
        throw new IllegalStateException(
                "Cannot initialize context because there is already a root application context present - " +
                "check whether you have multiple ContextLoader* definitions in your web.xml!");
    }

    servletContext.log("Initializing Spring root WebApplicationContext");
    Log logger = LogFactory.getLog(ContextLoader.class);
    if (logger.isInfoEnabled()) {
        logger.info("Root WebApplicationContext: initialization started");
    }
    long startTime = System.currentTimeMillis();

    try {
        // context 可以通过构造方法传入(这个在 java config 方式会用到)
        if (this.context == null) {
            // 若 web application 为空，创建一个, 这个一般是 web.xml 方式配置的
            this.context = createWebApplicationContext(servletContext);
        }
        if (this.context instanceof ConfigurableWebApplicationContext) {
            ConfigurableWebApplicationContext cwac = (ConfigurableWebApplicationContext) this.context;
            if (!cwac.isActive()) {
                // The context has not yet been refreshed -> provide services such as
                // setting the parent context, setting the application context id, etc
                if (cwac.getParent() == null) {
                    // The context instance was injected without an explicit parent ->
                    // determine parent for root web application context, if any.
                    ApplicationContext parent = loadParentContext(servletContext);
                    cwac.setParent(parent);
                }
                // 设置 ID, ServletContext, contextConfigLocation
                // 执行 refresh 操作
                configureAndRefreshWebApplicationContext(cwac, servletContext);
            }
        }

        // 将 web application context 放进 servlet context 中
        // 因此可以调用 servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE) 拿到这个 WebApplicationContext
        // 更简单的方法是通过 SpringMVC 提供的工具类 WebApplicationContextUtils.getWebApplicationContext(servletContext)
        servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, this.context);

        ClassLoader ccl = Thread.currentThread().getContextClassLoader();
        if (ccl == ContextLoader.class.getClassLoader()) {
            currentContext = this.context;
        }
        else if (ccl != null) {
            currentContextPerThread.put(ccl, this.context);
        }

        if (logger.isInfoEnabled()) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            logger.info("Root WebApplicationContext initialized in " + elapsedTime + " ms");
        }

        return this.context;
    }
    catch (RuntimeException | Error ex) {
        logger.error("Context initialization failed", ex);
        servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, ex);
        throw ex;
    }
}

/**
 * ContextLoader#configureAndRefreshWebApplicationContext
 */
protected void configureAndRefreshWebApplicationContext(ConfigurableWebApplicationContext wac, ServletContext sc) {
        if (ObjectUtils.identityToString(wac).equals(wac.getId())) {
        // The application context id is still set to its original default value
        // -> assign a more useful id based on available information
        String idParam = sc.getInitParameter(CONTEXT_ID_PARAM);
        if (idParam != null) {
        wac.setId(idParam);
        }
        else {
        // Generate default id...
        wac.setId(ConfigurableWebApplicationContext.APPLICATION_CONTEXT_ID_PREFIX +
        ObjectUtils.getDisplayString(sc.getContextPath()));
        }
        }

        // WebApplication 会持有当前 ServletContext
        wac.setServletContext(sc);
        // CONFIG_LOCATION_PARAM = "contextConfigLocation", web.xml 里面配置参数 
        // root web application context 的 Bean 配置文件
        String configLocationParam = sc.getInitParameter(CONFIG_LOCATION_PARAM);
        if (configLocationParam != null) {
        wac.setConfigLocation(configLocationParam);
        }

        // The wac environment's #initPropertySources will be called in any case when the context
        // is refreshed; do it eagerly here to ensure servlet property sources are in place for
        // use in any post-processing or initialization that occurs below prior to #refresh
        ConfigurableEnvironment env = wac.getEnvironment();
        if (env instanceof ConfigurableWebEnvironment) {
        // 初始化属性资源，占位符等
        // 在这里调用确保 servlet 属性资源在 post-processing 和 initialization 阶段是可用的
        ((ConfigurableWebEnvironment) env).initPropertySources(sc, null);
        }

        // ApplicationContextInitializer 回调接口，在 refresh 之前定制一些信息
        customizeContext(sc, wac);

        // 所有的 ApplicationContext 调用 refresh 之后才可用，此方法位于
        // AbstractApplication，它统一了 ApplicationContext 初始化的基本
        // 流程，子类（包括 WebApplicationContext 的实现类）通过钩子方法
        //（模版方法）定制一些自己的需求
        // web refresh 流程上面以已经说过
        wac.refresh();
        }

/**
 * ContextLoaderListener 的初始化流程可以用下面的代码表示
 *def initWebApplicationContext():
        if context == null:
                context = createWebApplicationContext()
        configureAndRefreshWebApplicationContext(context)
 */

```

6、DispatcherServlet 初始化流程
```java
//HttpServletBean#init -> FrameworkServlet#initServletBean -> FrameworkServlet#initWebApplicationContext

//FrameworkServlet#initWebApplicationContext
/**
 * Initialize and publish the WebApplicationContext for this servlet.
 * <p>Delegates to {@link #createWebApplicationContext} for actual creation
 * of the context. Can be overridden in subclasses.
 * @return the WebApplicationContext instance
 * @see #FrameworkServlet(WebApplicationContext)
 * @see #setContextClass
 * @see #setContextConfigLocation
 */
protected WebApplicationContext initWebApplicationContext() {
        // 获取根容器，ServletContext 持有的 WebApplicationContext
        WebApplicationContext rootContext =
        WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        // 上下文容器，当前 DispatcherServlet 持有的 WebApplicationContext
        WebApplicationContext wac = null;

        // web application 可以通过构造方法传入， java-config 方式会用到
        if (this.webApplicationContext != null) {
        wac = this.webApplicationContext;
        if (wac instanceof ConfigurableWebApplicationContext) {
        ConfigurableWebApplicationContext cwac = (ConfigurableWebApplicationContext) wac;
        if (!cwac.isActive()) {
        // The context has not yet been refreshed -> provide services such as
        // setting the parent context, setting the application context id, etc
        if (cwac.getParent() == null) {
        // The context instance was injected without an explicit parent -> set
        // the root application context (if any; may be null) as the parent
        cwac.setParent(rootContext);
        }

        // 配置刷新 web application context, 下面会说到
        configureAndRefreshWebApplicationContext(cwac);
        }
        }
        }
        if (wac == null) {
        // No context instance was injected at construction time -> see if one
        // has been registered in the servlet context. If one exists, it is assumed
        // that the parent context (if any) has already been set and that the
        // user has performed any initialization such as setting the context id
        wac = findWebApplicationContext();
        }
        if (wac == null) {
        // 如果通过 web.xml 方式配置，此时 wac 为空，创建一个，默认 XmlWebApplicationContext
        // 配置文件位置 contextConfigLocation 在这里加载
        // 这个方法比较简单，不再赘述
        wac = createWebApplicationContext(rootContext);
        }

        if (!this.refreshEventReceived) {
// 初始化 SpringMVC 处理过程中面向不同功能的策略对象
// 比如 MultipartResolver, HandlerMappings, ViewResolvers 等
synchronized (this.onRefreshMonitor) {
        onRefresh(wac);
        }
        }

        if (this.publishContext) {
        // 将 DispatcherServlet 持有的 web application context 放进 ServletContext
        // 命名规则为 SERVLET_CONTEXT_PREFIX + dispatcherServlet 名字
        // SERVLET_CONTEXT_PREFIX = FrameWorkServlet.class.getName() + ".CONTEXT."
        String attrName = getServletContextAttributeName();
        getServletContext().setAttribute(attrName, wac);
        }

        return wac;
        }

//FrameworkServlet#createWebApplicationContext
// web.xml 配置方式需要调用此方法创建 WebApplicationContext
// java-config 一般通过构造方法传入，不需要再创建，上面有示例
protected WebApplicationContext createWebApplicationContext(@Nullable ApplicationContext parent) {
        // 返回 WebApplicationContext 的实现类，默认为 XmlWebApplicationContext
        Class<?> contextClass = getContextClass();
        if (!ConfigurableWebApplicationContext.class.isAssignableFrom(contextClass)) {
        throw new ApplicationContextException(
        "Fatal initialization error in servlet with name '" + getServletName() +
        "': custom WebApplicationContext class [" + contextClass.getName() +
        "] is not of type ConfigurableWebApplicationContext");
        }
        ConfigurableWebApplicationContext wac =
        (ConfigurableWebApplicationContext) BeanUtils.instantiateClass(contextClass);

        wac.setEnvironment(getEnvironment());
        // parent 为 rootContext
        wac.setParent(parent);

        // 获 bean 取配置文件位置
        String configLocation = getContextConfigLocation();
        if (configLocation != null) {
        wac.setConfigLocation(configLocation);
        }

        // 配置，刷新容器，下面会说到
        configureAndRefreshWebApplicationContext(wac);

        return wac;
        }

//FrameworkServlet#configureAndRefreshWebApplicationContext
protected void configureAndRefreshWebApplicationContext(ConfigurableWebApplicationContext wac) {
        if (ObjectUtils.identityToString(wac).equals(wac.getId())) {
        // The application context id is still set to its original default value
        // -> assign a more useful id based on available information
        if (this.contextId != null) {
        wac.setId(this.contextId);
        }
        else {
        // Generate default id...
        wac.setId(ConfigurableWebApplicationContext.APPLICATION_CONTEXT_ID_PREFIX +
        ObjectUtils.getDisplayString(getServletContext().getContextPath()) + '/' + getServletName());
        }
        }

        // 配置 Servlet 相关信息
        wac.setServletContext(getServletContext());
        wac.setServletConfig(getServletConfig());
        wac.setNamespace(getNamespace());
        wac.addApplicationListener(new SourceFilteringListener(wac, new ContextRefreshListener()));

        // The wac environment's #initPropertySources will be called in any case when the context
        // is refreshed; do it eagerly here to ensure servlet property sources are in place for
        // use in any post-processing or initialization that occurs below prior to #refresh
        ConfigurableEnvironment env = wac.getEnvironment();
        if (env instanceof ConfigurableWebEnvironment) {
        // 初始化属性资源，占位符等
        // 在这里调用确保 servlet 属性资源在 post-processing 和 initialization 阶段是可用的
        ((ConfigurableWebEnvironment) env).initPropertySources(getServletContext(), getServletConfig());
        }

        // 空方法，可以在 refresh 之前配置一些信息
        postProcessWebApplicationContext(wac);
        // ApplicationContextInitializer 回调接口
        applyInitializers(wac);
        // 所有的 ApplicationContext 调用 refresh 之后才可用，此方法位于
        // AbstractApplication，它统一了 ApplicationContext 初始化的基本
        // 流程，子类（包括 WebApplicationContext 的实现类）通过钩子方法
        //（模版方法）定制一些自己的需求
        // web refresh 流程上面以已经说过
        wac.refresh();
        }

//DispatcherServlet#onRefresh
/**
 * This implementation calls {@link #initStrategies}.
 */
@Override
protected void onRefresh(ApplicationContext context) {
        // 初始化面向不同功能的策略对象
        initStrategies(context);
        }

//DispatcherServlet#initStrategies
protected void initStrategies(ApplicationContext context) {
        initMultipartResolver(context);
        initLocaleResolver(context);
        initThemeResolver(context);
        initHandlerMappings(context);
        initHandlerAdapters(context);
        initHandlerExceptionResolvers(context);
        initRequestToViewNameTranslator(context);
        initViewResolvers(context);
        initFlashMapManager(context);
        }

//DispatcherServlet#initHandlerMappings
private void initHandlerMappings(ApplicationContext context) {
        this.handlerMappings = null;

        // 默认为 true， 表示查找所有的 HandlerMappings 实现类
        if (this.detectAllHandlerMappings) {
        // 从 ApplicationContext（包括父容器）中查找所有的 HandlerMappings
        Map<String, HandlerMapping> matchingBeans =
        BeanFactoryUtils.beansOfTypeIncludingAncestors(context, HandlerMapping.class, true, false);
        if (!matchingBeans.isEmpty()) {
        this.handlerMappings = new ArrayList<>(matchingBeans.values());
        // We keep HandlerMappings in sorted order.
        AnnotationAwareOrderComparator.sort(this.handlerMappings);
        }
        }
        else {
        try {
        // 只加载名字为 handlerMapping 的 HandlerMapping
        HandlerMapping hm = context.getBean(HANDLER_MAPPING_BEAN_NAME, HandlerMapping.class);
        this.handlerMappings = Collections.singletonList(hm);
        }
        catch (NoSuchBeanDefinitionException ex) {
        // Ignore, we'll add a default HandlerMapping later.
        }
        }

        // 确保至少有一个 HandlerMapping
        if (this.handlerMappings == null) {
        // 加载默认的 HandlerMapping, 下面会说到
        this.handlerMappings = getDefaultStrategies(context, HandlerMapping.class);
        if (logger.isTraceEnabled()) {
        logger.trace("No HandlerMappings declared for servlet '" + getServletName() +
        "': using default strategies from DispatcherServlet.properties");
        }
        }
        }

//DispatcherServlet 的初始化流程可以表示为
/**
 def initWebApplicationContext():
     rootContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext())
     if context == null:
            context = createWebApplicationContext(rootContext)
     context.setParent(rootContext)
     configureAndRefreshWebApplicationContext(context)
     onRefresh(context)
 */
```

6、DispatcherServlet 处理流程
```java


public interface HandlerInterceptor {

    // 在 handler 执行前拦截，返回 true 才能继续调用下一个 interceptor 或者 handler
    default boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    // 在 handler 执行后，视图渲染前进行拦截处理
    default void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        @Nullable ModelAndView modelAndView) throws Exception {
    }

    // 视图渲染后，请求完成后进行处理，可以用来清理资源
    // 除非 preHandle 放回 false，否则一定会执行，即使发生错误
    default void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
        @Nullable Exception ex) throws Exception {
    }

}

//大致流程：HttpServlet#service -> FrameworkServlet#processRequest -> DispatcherServlet#doService -> DispatcherServlet#doDispatch
protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpServletRequest processedRequest = request;
    HandlerExecutionChain mappedHandler = null;
    boolean multipartRequestParsed = false;

    WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);

    try {
        ModelAndView mv = null;
        Exception dispatchException = null;

        try {
            // 检查是否为文件上传请求
            processedRequest = checkMultipart(request);
            multipartRequestParsed = (processedRequest != request);

            // 通过 handlerMapping 查到请求对应的 handler
            // 返回 HandlerExecutionChain 里面包含 handler 和 interceptors
            mappedHandler = getHandler(processedRequest);
            if (mappedHandler == null) {
                noHandlerFound(processedRequest, response);
                return;
            }

            // 根据 handler 匹配对应的 handlerAdapter
            HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());

            // Process last-modified header, if supported by the handler.
            String method = request.getMethod();
            boolean isGet = "GET".equals(method);
            if (isGet || "HEAD".equals(method)) {
                long lastModified = ha.getLastModified(request, mappedHandler.getHandler());
                if (new ServletWebRequest(request, response).checkNotModified(lastModified) && isGet) {
                    return;
                }
            }

            // 拦截器前置处理，调用 HandlerInterceptor#preHandle
            if (!mappedHandler.applyPreHandle(processedRequest, response)) {
                return;
            }

            // 调用 handler, 就是 @Controller 注解的类对应的方法
            // 如果是一个 rest 请求，mv 为 null，后面不会再调用 render 方法
            mv = ha.handle(processedRequest, response, mappedHandler.getHandler());

            if (asyncManager.isConcurrentHandlingStarted()) {
                return;
            }

            // 设置 viewName, 后面会根据 viewName 找到对应的 view
            applyDefaultViewName(processedRequest, mv);

            // 拦截器后置处理，调用 HandlerInterceptor#postHandle
            mappedHandler.applyPostHandle(processedRequest, response, mv);
        }
        catch (Exception ex) {
            dispatchException = ex;
        }
        catch (Throwable err) {
            // As of 4.3, we're processing Errors thrown from handler methods as well,
            // making them available for @ExceptionHandler methods and other scenarios.
            dispatchException = new NestedServletException("Handler dispatch failed", err);
        }

        // 结果处理，错误，视图等
        processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException);
    }
    catch (Exception ex) {
        // 拦截器结束处理, 调用 HandlerInterceptor#afterCompletion
        // 即使发生错误也会执行
        triggerAfterCompletion(processedRequest, response, mappedHandler, ex);
    }
    catch (Throwable err) {
        triggerAfterCompletion(processedRequest, response, mappedHandler,
                new NestedServletException("Handler processing failed", err));
    }
    finally {
        if (asyncManager.isConcurrentHandlingStarted()) {
            // Instead of postHandle and afterCompletion
            if (mappedHandler != null) {
                mappedHandler.applyAfterConcurrentHandlingStarted(processedRequest, response);
            }
        }
        else {
            // Clean up any resources used by a multipart request.
            if (multipartRequestParsed) {
                cleanupMultipart(processedRequest);
            }
        }
    }
}

```

7、总结
```text

SpringMVC 是基于 Servlet 的, 因此 SpringMVC 的启动流程基于 Servlet 的启动流程

ServletContext 持有的 WebApplicationContext 称为根容器; 根容器在一个 web 应用中都可以访问到，因此可以用于注册共享的 bean；如果不需要可以不创建，根容器不是必要的

根容器是指在 ServletContext 中以 WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE 为 key 的 WebApplicationContext。根容器并不一定要由 ContextLoaderListener 创建。

DispatcherServlet 持有的 WebApplicationContext 称为它的上下文容器；每个 DispatcherServlet 都会持有一个上下文容器(自己创建或者构造传入)。

SpringMVC 的处理流程并不一定按上面的顺序执行，比如如果是 json 请求，HandlerAdapter 调用 handler 处理后返回的 mv 可能是 null, 后面就不会进行视图渲染

请求如果没有到达 DispatcherServlet 可能是被过滤器过滤了（权限？异常？）；一定不是被拦截器拦截的，因为拦截器在 DispatcherServlet 内部执行。

除非请求被 interceptor#preHandle 拦截，否则 interceptor#afterCompletion 一定会执行，即使发生错误。


```



