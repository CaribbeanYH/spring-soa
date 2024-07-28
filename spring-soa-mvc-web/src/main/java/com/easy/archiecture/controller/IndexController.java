package com.easy.archiecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/29 00:53
 */
@Controller
@ResponseBody
@RequestMapping("/home")
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "spring-mvc project";
    }
}
