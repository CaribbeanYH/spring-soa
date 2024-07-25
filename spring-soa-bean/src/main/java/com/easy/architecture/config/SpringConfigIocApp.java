package com.easy.architecture.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanghai10
 * @ClassName SpringConfigIocApp
 * @Description Spring注解启动容器
 * @date 2023/12/21 15:00
 */
public class SpringConfigIocApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProxyManager proxyManager = (ProxyManager) context.getBean("proxyManager");
        proxyManager.getName();
        proxyManager.allWrite();

//        Gson gson = (Gson) context.getBean("GsonObject");
//        ProxyManager proxyManager1 = context.getBean(ProxyManager.class);
//        Map<String, String> map = new HashMap<String, String>() {
//            {
//                put("a", "b");
//                put("c", "d");
//            }
//        };
//        System.out.println(gson.toJson(map));
//        SelfEvenetPub eventPub = (SelfEvenetPub) context.getBean("selfEvenetPub");
//        eventPub.publish();
//        eventPub.publish();
    }
}
