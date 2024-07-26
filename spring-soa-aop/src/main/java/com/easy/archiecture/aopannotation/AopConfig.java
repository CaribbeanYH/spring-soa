package com.easy.archiecture.aopannotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.easy.archiecture.springaop.aopannotation")
@EnableAspectJAutoProxy
public class AopConfig {
}
