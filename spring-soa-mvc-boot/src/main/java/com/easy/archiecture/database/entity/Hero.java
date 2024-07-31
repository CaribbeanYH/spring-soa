package com.easy.archiecture.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("hero_info")
public class Hero implements Serializable {

    private static final long serialVersionUID = -5721553201919442515L;

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 名字
     */
    private String heroName;

    /**
     * 描述
     */
    private String heroDesc;

    /**
     * 技能
     */
    private String heroAbility;

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

    /**
     * 有效标记 1:有效 0:无效
     */
    private Integer yn;
}
