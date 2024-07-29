package com.easy.archiecture.service.impl;

import com.easy.archiecture.bean.view.HeroVO;
import com.easy.archiecture.service.IHeroService;
import org.springframework.stereotype.Service;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/29 15:01
 */
@Service("iHeroService")
public class HeroServiceImpls implements IHeroService {

    @Override
    public HeroVO queryHeroInfo(Long heroId) {
        if (null == heroId || heroId <= 0) {
            return null;
        }
        HeroVO heroVO = new HeroVO();
        heroVO.setAbility("");
        heroVO.setDesc("");
        heroVO.setName("");
        return heroVO;
    }
}
