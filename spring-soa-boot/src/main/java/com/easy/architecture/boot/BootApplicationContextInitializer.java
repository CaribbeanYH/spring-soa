package com.easy.architecture.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author yanghai
 * @ClassName
 * @Description
 * @date 2024/7/31 01:38
 */
public class BootApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private Logger logger = LoggerFactory.getLogger(BootApplicationContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        logger.info("BootApplicationContextInitializer init success");
    }
}
