package com.rl.mes.controller;

import com.rl.mes.service.ExteriorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 外观检查控制器
 *
 */
@Controller
@RequestMapping("/exterior")
public class ExteriorController {

    @Autowired
    private ExteriorService exteriorService;


    /**
     * 获取外观检查列表---layer组件
     *
     * @return
     */
    @RequestMapping({"/list.do"})
    public ModelAndView getExteriorList(@RequestParam(value = "barcode",required = false)String barcode) {
        return new ModelAndView("exterior-list").addObject("barcode",barcode);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping({"/delete.do"})
    public ModelAndView delete(@RequestParam("id") String id) {
        exteriorService.doDelete(id);
        return getExteriorList(null);
    }

}
