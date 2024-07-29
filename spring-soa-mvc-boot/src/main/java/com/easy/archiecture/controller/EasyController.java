package com.easy.archiecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yanghai
 * @ClassName
 * @Description
 * @date 2024/7/28 16:44
 */
@Controller
@ResponseBody
@RequestMapping("/home")
public class EasyController {

    @RequestMapping(value = "/index")
    public String home() {
        return "index";
    }
}
