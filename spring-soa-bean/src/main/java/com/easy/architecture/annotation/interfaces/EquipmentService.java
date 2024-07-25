package com.easy.architecture.annotation.interfaces;

import com.easy.architecture.annotation.Equipment;

/**
 * @author yanghai10
 * @ClassName EquipmentService
 * @Description
 * @date 2024/7/25 14:39
 */
public interface EquipmentService {

    /**
     * @param equipmentId 设备ID
     * @function 查询指定设备的信息
     * @returns 设备信息，若设备不存在则返回null
     */
    Equipment queryEquipment(String equipmentId);
}
