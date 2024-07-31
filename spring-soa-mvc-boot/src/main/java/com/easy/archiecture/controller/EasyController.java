package com.easy.archiecture.controller;

import com.easy.archiecture.bean.views.BootModel;
import com.easy.archiecture.bean.ResultDTO;
import com.easy.archiecture.bean.views.HeroVO;
import com.easy.archiecture.enums.ResultCodeEnum;
import com.easy.archiecture.service.IBootService;
import com.easy.archiecture.service.IHeroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Resource
    private IHeroService iHeroService;

    @RequestMapping(value = "/name")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/boot")
    public ResultDTO<BootModel> boot() {
        return ResultDTO.buildSuccess(iBootService.queryBootInfo());
    }

    @RequestMapping(value = "/queryHero")
    public ResultDTO<HeroVO> queryHero(@RequestParam(value = "heroId") Long heroId) {
        if (null == heroId || heroId <= 0) {
            return ResultDTO.buildFail(ResultCodeEnum.PARAMS_IS_NULL.getCode(), ResultCodeEnum.PARAMS_IS_NULL.getMessage());
        }
        HeroVO heroVO = iHeroService.queryHero(heroId);
        return ResultDTO.buildSuccess(heroVO);
    }
}
