package com.easy.archiecture.controller;

import com.easy.archiecture.bean.response.ResultDTO;
import com.easy.archiecture.bean.view.HeroVO;
import com.easy.archiecture.enums.ResultCodeEnum;
import com.easy.archiecture.service.IHeroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/29 00:53
 */
@Controller
@ResponseBody
@RequestMapping("/home")
public class HeroController {

    @Resource
    private IHeroService iHeroService;

    @RequestMapping(value = "/heroInfo", method = RequestMethod.GET)
    public ResultDTO<HeroVO> heroInfo(@RequestParam(value = "heroId", required = false) Long heroId) {
        if (null == heroId || heroId <= 0) {
            return ResultDTO.buildFail(ResultCodeEnum.PARAMS_IS_NULL.getCode(), ResultCodeEnum.PARAMS_IS_NULL.getMessage());
        }
        HeroVO heroVO = iHeroService.queryHeroInfo(heroId);
        return ResultDTO.buildSuccess(heroVO);
    }
}
