package com.easy.architecture.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

/**
 * @author yanghai
 * @ClassName
 * @Description
 * @date 2024/8/1 00:33
 */
public class BootRunner implements ApplicationRunner, CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(BootRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("BootRunner run {}", args.toString());
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("BootRunner run {}", Arrays.toString(args));
    }
}
