package com.rl.mes.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 参照控制器
 */
@Controller
public class ReferenceController {

    @RequestMapping("/reference")
    public ModelAndView reference(@Param("url") String url, @Param("jsPath") String jsPath, @Param("multiSelect") Boolean multiSelect) {
        return new ModelAndView("menu-list");
    }

}
