package com.easy.archiecture.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author yanghai
 * @ClassName
 * @Description
 * @date 2024/7/28 16:38
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.easy.archiecture")
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
        internalResourceViewResolver.setPrefix("/view/");
        //请求页面文件的后缀
        internalResourceViewResolver.setSuffix(".html");
        return internalResourceViewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("/static/");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("file:D:/data/");//本地路径
    }
}
