package com.easy.archiecture.controller;

import com.easy.archiecture.bean.BootModel;
import com.easy.archiecture.bean.ResultDTO;
import com.easy.archiecture.service.IBootService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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

    @Resource
    private IBootService iBootService;

    @RequestMapping(value = "/index")
    public String home() {
        return "name";
    }

    @RequestMapping(value = "/boot")
    public ResultDTO<BootModel> boot() {
        return ResultDTO.buildSuccess(iBootService.queryBootInfo());
    }
}
