package com.easy.architecture.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigTestMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Company company = (Company) context.getBean("company");
        company.getPersonName();
        company.allWrite();

//        Gson gson = (Gson) context.getBean("GsonObject");
//
//        Company company1 = context.getBean(Company.class);
//        Map<String, String> map = new HashMap<String, String>() {
//            {
//                put("a", "b");
//                put("c", "d");
//            }
//        };
//        System.out.println(gson.toJson(map));




//        SelfEvenetPub eventPub = (SelfEvenetPub)context.getBean("selfEvenetPub");
//        eventPub.publish();
//        eventPub.publish();

    }
}
