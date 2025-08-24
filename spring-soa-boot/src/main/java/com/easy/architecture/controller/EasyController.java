package com.easy.architecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2025/8/24 10:29
 */
@Controller
@ResponseBody
@RequestMapping("/home")
public class EasyController {

    @RequestMapping(value = "/name")
    public String home() {
        return "home";
    }
}
