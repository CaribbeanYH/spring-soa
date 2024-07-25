package com.easy.architecture.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LazyRoleImpl {

    private ProxyManager proxyManager;

    public LazyRoleImpl(ProxyManager proxyManager) {
        this.proxyManager = proxyManager;
    }

    public String getName() {
        return "LAZY";
    }
}
