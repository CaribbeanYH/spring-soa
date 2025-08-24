```text
--------------------------------创建springbootApplication对象---------------------------------------------
1. 创建springbootApplication对象springboot容器初始化操作
2. 获取当前应用的启动类型。
	注1：通过判断当前classpath是否加载servlet类，返回servlet web启动方式。
	注2：webApplicationType三种类型：
		1.reactive：响应式启动（spring5新特性）
		2.none:即不嵌入web容器启动（springboot放在外部服务器运行 ）
		3.servlet:基于web容器进行启动
3. 读取springboot下的META-INFO/spring.factories文件，获取对应的ApplicationContextInitializer装配到集合
4. 读取springboot下的META-INFO/spring.factories文件，获取对应的ApplicationListener装配到集合
5. mainApplicationClass，获取当前运行的主函数
6. 
7. 
------------------调用springbootApplication对象的run方法，实现启动，返回当前容器的上下文----------------------------------------------
8. 调用run方法启动
9. StopWatch stopWatch = new StopWatch()，记录项目启动时间
10. getRunListeners，读取META-INF/spring.factores，将SpringApplicationRunListeners类型存到集合中
11. listeners.starting();循环调用starting方法
12. prepareEnvironment(listeners, applicationArguments);将配置文件读取到容器中
		读取多数据源：classpath:/,classpath:/config/,file:./,file:./config/底下。其中classpath是读取编译后的，file是读取编译前的
		支持yml，yaml，xml，properties
13. Banner printedBanner = printBanner(environment);开始打印banner图，就是sprongboot启动最开头的图案
14. 初始化AnnotationConfigServletWebServerApplicationContext对象
15. 刷新上下文，调用注解，refreshContext(context);
16. 创建tomcat
17. 加载springmvc
18. 刷新后的方法，空方法，给用户自定义重写afterRefresh（）
19. stopWatch.stop();结束计时
20. 使用广播和回调机制告诉监听者springboot容器已经启动化成功，listeners.started(context);
21. 使用广播和回调机制告诉监听者springboot容器已经启动化成功，listeners.started(context);
22. 返回上下文

```