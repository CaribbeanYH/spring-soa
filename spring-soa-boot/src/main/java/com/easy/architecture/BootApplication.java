package com.easy.architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
    // 刷spring容器（构建一个dispather，web服务的工厂，整个项目的springbean） --》
    // 监听spring容器刷完的事件，创建webServer并启动，并同时启动bootStrup()
    // web容器初始化（dispatherServlet）
    // 1、Springboot启动流程的时序图UML
    // springboot 集成 DB（mysql，mongo，，es，influxdb，maridb），缓存（couchbase, redis），MQ（kafka，rabbitmq，rocketMQ，plusar）
}
