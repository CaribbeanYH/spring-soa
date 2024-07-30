package com.easy.archiecture.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/30 10:37
 */
@Configuration
@ComponentScan(basePackages = "com.easy.archiecture")
@EnableAspectJAutoProxy(proxyTargetClass = true) //使用CGlib的方式来实现动态代理
public class AppConfig {
}
