package com.easy.architecture.springFactory;

/**
 * @author yanghai
 * @ClassName
 * @Description
 * @date 2024/7/26 00:35
 */
public class HeroFactory {

    public Hero getHero(String arg) {
        if (arg.equalsIgnoreCase("yuji")) {
            return new YuJi();
        } else {
            return new LvBu();
        }
    }
}
