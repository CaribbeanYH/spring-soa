package com.easy.archiecture.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.easy.archiecture.bean.views.HeroVO;
import com.easy.archiecture.convert.HeroConvert;
import com.easy.archiecture.database.entity.Hero;
import com.easy.archiecture.service.IHeroService;
import org.springframework.stereotype.Service;
import com.easy.archiecture.database.mappers.HeroMapper;

import javax.annotation.Resource;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/31 16:32
 */
@Service("iHeroService")
public class HeroImpl implements IHeroService {

    @Resource
    private HeroMapper heroMapper;

    @Override
    public HeroVO queryHero(Long heroId) {
        LambdaQueryWrapper<Hero> heroLambdaQueryWrapper = new LambdaQueryWrapper<>();
        heroLambdaQueryWrapper.eq(Hero::getId, heroId);
        Hero hero = heroMapper.selectOne(heroLambdaQueryWrapper);
        if (null == hero) {
            return null;
        }
        return HeroConvert.INSTANCE.convertToHeroVO(hero);
    }
}
