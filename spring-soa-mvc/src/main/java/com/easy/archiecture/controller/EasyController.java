package com.easy.archiecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yanghai
 * @ClassName
 * @Description
 * @date 2024/7/28 16:44
 */
@Controller
public class EasyController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showForm() {
        return "mvc";
    }
}
