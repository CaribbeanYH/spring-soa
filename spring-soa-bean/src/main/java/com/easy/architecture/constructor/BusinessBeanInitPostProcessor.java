package com.easy.architecture.constructor;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

/**
 * @author yanghai
 * @ClassName BusinessBeanPostProcessor
 * @Description spring bean后置处理器
 * @date 2024/7/26 00:35
 */
//@Configuration
public class BusinessBeanInitPostProcessor implements BeanPostProcessor {

    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "初始化之前" + JSON.toJSONString(bean));
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "初始化之后" + JSON.toJSONString(bean));
        return bean;
    }
}
