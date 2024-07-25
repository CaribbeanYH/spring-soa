package com.easy.architecture.annotation;

import javax.inject.Named;
import java.io.Serializable;

/**
 * @author yanghai10
 * @ClassName HuangZhong
 * @Description 黄忠
 * @date 2024/7/25 14:44
 */
@Named
public class HuangZhong implements Serializable {

    private String name;

    private Equipment equipment;
}
