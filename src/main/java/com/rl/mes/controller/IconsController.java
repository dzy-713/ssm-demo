package com.rl.mes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 图标控制器
 */
@Controller
@RequestMapping("/icons")
public class IconsController {

    @RequestMapping({"/view.do"})
    public ModelAndView getMenuTree() {
        return new ModelAndView("icon-page");
    }

}
