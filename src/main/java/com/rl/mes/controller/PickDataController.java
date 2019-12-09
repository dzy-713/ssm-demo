package com.rl.mes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 采集数据控制器
 *
 */
@Controller
@RequestMapping("/pickData")
public class PickDataController {


    /**
     * 综合数据列表
     *
     * @return
     */
    @RequestMapping({"/list.do"})
    public ModelAndView getBurnList() {
        return new ModelAndView("pickData-list");
    }


}
