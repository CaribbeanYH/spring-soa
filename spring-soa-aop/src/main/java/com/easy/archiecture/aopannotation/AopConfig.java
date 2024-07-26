package com.easy.archiecture.aopannotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
@Configuration
@ComponentScan(basePackages = "com.easy.archiecture.aopannotation")
@EnableAspectJAutoProxy
public class AopConfig {
}
