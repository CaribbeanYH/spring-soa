package com.easy.archiecture.bean.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/29 15:14
 */
@Data
public class HeroQueryVO implements Serializable {

    private static final long serialVersionUID = 1446984172731429164L;

    /**
     * 英雄ID
     */
    private Long heroId;
}
