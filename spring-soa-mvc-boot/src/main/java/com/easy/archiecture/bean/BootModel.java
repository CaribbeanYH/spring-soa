package com.easy.archiecture.bean;

import lombok.*;

import java.io.Serializable;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/30 18:30
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BootModel implements Serializable {
    private static final long serialVersionUID = -1946225038043503283L;

    private String bootName;

    private String bootDesc;
}
