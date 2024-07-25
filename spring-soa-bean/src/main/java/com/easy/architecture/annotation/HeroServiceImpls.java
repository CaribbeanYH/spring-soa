package com.easy.architecture.annotation;

import com.easy.architecture.annotation.interfaces.EquipmentService;
import com.easy.architecture.annotation.interfaces.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author yanghai10
 * @ClassName HeroServiceImpls
 * @Description
 * @date 2024/7/25 17:42
 */
@Service("heroService")
public class HeroServiceImpls implements HeroService {

    @Inject
//    @Named
//    @Autowired
//    @Resource
    private EquipmentService equipmentService;

//    @Inject
//    @Autowired
    @Resource
    private HuangZhong huangZhong;

    @Override
    public Object queryHero(Long heroId) throws Exception {
        if (null == heroId
                || heroId == 0) {
            throw new Exception("参数异常");
        }
        return huangZhong;
    }
}
