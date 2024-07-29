package com.easy.archiecture.bean.view;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/29 14:57
 */
@Data
public class HeroVO implements Serializable {
    private static final long serialVersionUID = -6220720544481346631L;

    private String name;

    private String desc;

    private String ability;
}
