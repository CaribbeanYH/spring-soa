package com.easy.archiecture.service;

import com.easy.archiecture.bean.views.HeroVO;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/31 16:28
 */
public interface IHeroService {

    HeroVO queryHero(Long heroId);
}
