package com.easy.architecture.excellent;

import com.easy.architecture.javaconfig.AppConfig;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.EnumMap;

public class SimpleBusinessFactory implements InitializingBean {


    private final EnumMap<BusinessDataType, HandlerInterface> builderEnumMap = new EnumMap<>(BusinessDataType.class);


    @Override
    public void afterPropertiesSet() throws Exception {
        BeanFactoryUtils.beansOfTypeIncludingAncestors(new AnnotationConfigApplicationContext(AppConfig.class), HandlerInterface.class, false, true)
                .values().forEach(e -> {
            BusinessType annotation = e.getClass().getAnnotation(BusinessType.class);
            if (annotation != null) {
                BusinessDataType[] lightCourseCardTypes = annotation.businessTypes();
                for (BusinessDataType dataType : lightCourseCardTypes) {
                    builderEnumMap.put(dataType, e);
                }
            }
        });
    }


    public void dataHandle(String dataType) {
        BusinessDataType businessDataType = BusinessDataType.valueOf(dataType);
        HandlerInterface handlerInterface = builderEnumMap.get(businessDataType);
        if (handlerInterface != null) {
            handlerInterface.handle();
        }
    }
}
