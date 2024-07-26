package com.easy.architecture.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanghai10
 * @ClassName SpringAnnotationIocApp
 * @Description Spring注解启动容器
 * @date 2023/12/21 15:00
 */
public class SpringAnnotationIocApp {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-xml-config.xml");
        HeroCaoCao heroCaoCao = (HeroCaoCao) applicationContext.getBean("heroCaoCao");
        heroCaoCao.ability();
//        heroCaoCao.input();
//        HeroCaoCao heroCaoCao1 = (HeroCaoCao) applicationContext.getBean("heroCaoCao");
//        System.out.println(heroCaoCao == heroCaoCao1);
//        HeroCaoCao p1=new HeroCaoCao();
//        p1.setName("aaaaa");
//        p1.input();
//        Class<?> clazz = Class.forName("com.easy.com.easy.archiecture.constructor.HeroCaoCao");
//        Object o = clazz.newInstance();
    }
}

/*
// 刷新容器的处理
public void refresh() throws BeansException, IllegalStateException {
	synchronized (this.startupShutdownMonitor) {
		// 1. 刷新前的预处理
		prepareRefresh();

		// 2. 获取 beanFactory，即前面创建的【DefaultListableBeanFactory】
		ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

		// 3. 预处理 beanFactory，向容器中添加一些组件
		prepareBeanFactory(beanFactory);

		try {
			// 4. 子类通过重写这个方法可以在 BeanFactory 创建并与准备完成以后做进一步的设置
			postProcessBeanFactory(beanFactory);

			// 5. 执行 BeanFactoryPostProcessor 方法，beanFactory 后置处理器
			invokeBeanFactoryPostProcessors(beanFactory);

			// 6. 注册 BeanPostProcessors，bean 后置处理器
			registerBeanPostProcessors(beanFactory);

			// 7. 初始化 MessageSource 组件（做国际化功能；消息绑定，消息解析）
			initMessageSource();

			// 8. 初始化事件派发器，在注册监听器时会用到
			initApplicationEventMulticaster();

			// 9. 留给子容器（子类），子类重写这个方法，在容器刷新的时候可以自定义逻辑，web 场景下会使用
			onRefresh();

			// 10. 注册监听器，派发之前步骤产生的一些事件（可能没有）
			registerListeners();

			// 11. 初始化所有的非单实例 bean
			finishBeanFactoryInitialization(beanFactory);

			// 12. 发布容器刷新完成事件
			finishRefresh();
		}
		...
	}
}
 */
