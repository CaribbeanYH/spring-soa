package com.easy.archiecture.service.impl;

import com.easy.archiecture.bean.views.BootModel;
import com.easy.archiecture.service.IBootService;
import org.springframework.stereotype.Service;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/30 18:27
 */
@Service("iBootService")
public class BootServiceImpl implements IBootService {

    @Override
    public BootModel queryBootInfo() {
        return BootModel.builder()
                .bootName("Boot")
                .bootDesc("Boot Start Success")
                .build();

    }
}
