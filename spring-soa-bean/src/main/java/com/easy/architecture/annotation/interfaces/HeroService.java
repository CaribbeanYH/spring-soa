package com.easy.architecture.annotation.interfaces;

/**
 * @author yanghai10
 * @ClassName HeroService
 * @Description 英雄接口
 * @date 2024/7/25 15:05
 */
public interface HeroService {

    Object queryHero(Long heroId) throws Exception;
}
