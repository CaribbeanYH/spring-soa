package com.easy.architecture.config;

import com.easy.architecture.config.staregy.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
@Service
public class ProxyManager {

    @Autowired
//    @Lazy
    private LazyRoleImpl lazyRole;

    @Autowired
    private Map<String, Role> roleMap;

//    public ProxyManager(LazyRoleImpl lazyRole) {
//        this.lazyRole = lazyRole;
//    }

//    @Autowired
//    @Lazy
//    public void setLazyRole(LazyRoleImpl lazyRole) {
//        this.lazyRole = lazyRole;
//    }

    public void getName() {
        lazyRole.getName();
    }

    public void allWrite() {
        for (Map.Entry<String, Role> entry : roleMap.entrySet()) {
            entry.getValue().function();
        }
    }
}
