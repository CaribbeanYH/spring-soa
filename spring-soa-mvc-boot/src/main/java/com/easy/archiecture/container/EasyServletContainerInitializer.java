package com.easy.archiecture.container;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/28 18:27
 */
@Slf4j
public class EasyServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        log.info("servlet 容器加载中。。。。。。。");
    }
}
