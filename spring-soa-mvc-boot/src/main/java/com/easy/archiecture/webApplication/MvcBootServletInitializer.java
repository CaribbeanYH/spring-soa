//package com.easy.archiecture.webApplication;
//
//import com.easy.archiecture.config.AppConfig;
//import com.easy.archiecture.config.WebConfig;
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.servlet.Filter;
//
///**
// * @author yanghai
// * @ClassName
// * @Description 这个类就是web.xml的替代品
// * @date 2024/7/28 16:38
// */
//public class MvcBootServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{AppConfig.class};
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[]{WebConfig.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[]{
//                new CharacterEncodingFilter("UTF-8", true, true),
//        };
//    }
//}
