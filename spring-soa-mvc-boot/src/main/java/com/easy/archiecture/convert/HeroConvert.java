package com.easy.archiecture.convert;

import com.easy.archiecture.bean.views.HeroVO;
import com.easy.archiecture.database.entity.Hero;
import org.mapstruct.factory.Mappers;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/31 16:30
 */
public interface HeroConvert {

    HeroConvert INSTANCE = Mappers.getMapper(HeroConvert.class);

    HeroVO convertToHeroVO(Hero hero);
}
