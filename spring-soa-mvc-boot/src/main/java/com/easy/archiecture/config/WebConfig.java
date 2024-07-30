package com.easy.archiecture.config;


import com.easy.archiecture.interceptors.MvcInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * @author yanghai
 * @ClassName
 * @Description
 * @date 2024/7/28 16:38
 */
@EnableWebMvc
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true) //使用CGlib的方式来实现动态代理
public class WebConfig implements WebMvcConfigurer {

    //处理页面路径
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(resourceViewResolver());
    }

    //配置视图解析器
    @Bean
    public InternalResourceViewResolver resourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        //请求页面文件的前缀地址
        internalResourceViewResolver.setPrefix("views/");
        //请求页面文件的后缀
        internalResourceViewResolver.setSuffix(".html");
        return internalResourceViewResolver;
    }

    //静态资源访问
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //序列化
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(initMvcInterceptor());
    }

    @Bean
    public MvcInterceptor initMvcInterceptor() {
        return new MvcInterceptor();
    }
}
