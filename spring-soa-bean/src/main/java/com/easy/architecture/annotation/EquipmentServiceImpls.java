package com.easy.architecture.annotation;

import com.easy.architecture.annotation.interfaces.EquipmentService;
import org.springframework.stereotype.Service;

/**
 * @author yanghai10
 * @ClassName EquipmentServiceImpls
 * @Description 装备伤害查询类
 * @date 2024/7/25 14:41
 */
@Service("equipmentService")
//@Named  JSR 330标准注解 spring原生支持
//@Controller
//@Repository
//@Component
public class EquipmentServiceImpls implements EquipmentService {

    @Override
    public Equipment queryEquipment(String equipmentId) {
        return null;
    }
}
