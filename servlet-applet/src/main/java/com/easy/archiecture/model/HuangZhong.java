package com.easy.archiecture.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yanghai
 * @ClassName
 * @Description
 * @date 2024/7/27 01:48
 */
@Data
public class HuangZhong implements Serializable {
    private static final long serialVersionUID = 1907505946380846375L;

    /**
     * 英雄名称
     */
    private String name;

    /**
     * 英雄描述
     */
    private String desc;
}
