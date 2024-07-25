package com.easy.architecture.factory;

import com.easy.architecture.config.AppConfig;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.EnumMap;

/**
 * @author yanghai10
 * @ClassName BusinessHandlerFactory
 * @Description
 * @date 2024/7/25 14:44
 */
public class BusinessHandlerFactory implements InitializingBean {

    private final EnumMap<BusinessType, Handler> businessTypeHandlerEnumMap = new EnumMap<>(BusinessType.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        BeanFactoryUtils.beansOfTypeIncludingAncestors(new AnnotationConfigApplicationContext(AppConfig.class), Handler.class, false, true)
                .values().forEach(e -> {
                    Business annotation = e.getClass().getAnnotation(Business.class);
                    if (annotation != null) {
                        BusinessType[] lightCourseCardTypes = annotation.businessTypes();
                        for (BusinessType dataType : lightCourseCardTypes) {
                            businessTypeHandlerEnumMap.put(dataType, e);
                        }
                    }
                });
    }

    public void handler(String type) {
        BusinessType businessType = BusinessType.valueOf(type);
        Handler handler = businessTypeHandlerEnumMap.get(businessType);
        if (handler != null) {
            handler.handle();
        }
    }
}
