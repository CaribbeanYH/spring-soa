package com.easy.architecture.annotation;

import javax.inject.Named;
import java.io.Serializable;

/**
 * @author yanghai10
 * @ClassName Equipment
 * @Description 装备信息
 * @date 2024/7/25 14:51
 */
//@Named
public class Equipment implements Serializable {

    private String equipmentId;

    private String equipmentName;

    private String equipmentHarm;
}
