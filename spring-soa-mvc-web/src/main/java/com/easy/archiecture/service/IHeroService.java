package com.easy.archiecture.service;

import com.easy.archiecture.bean.view.HeroVO;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/29 14:56
 */
public interface IHeroService {

    HeroVO queryHeroInfo(Long heroId);
}
