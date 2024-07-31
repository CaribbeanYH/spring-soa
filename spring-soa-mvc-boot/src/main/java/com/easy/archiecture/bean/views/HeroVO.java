package com.easy.archiecture.bean.views;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/30 18:30
 */
@Data
public class HeroVO implements Serializable {

    private static final long serialVersionUID = -341167436259882089L;

    /**
     * 名字
     */
    private String name;

    /**
     * 描述
     */
    private String desc;

    /**
     * 技能
     */
    private String ability;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
