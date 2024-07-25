package org.easy.architecture.springbean;

import org.easy.architecture.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"spring-root.xml"});
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }
}
