package com.rl.mes.controller;

import com.rl.mes.service.PressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 压力测试控制器
 */
@Controller
@RequestMapping("/pressure")
public class PressureController {

    @Autowired
    private PressureService pressureService;


    /**
     * 获取压力测试列表---layer组件
     *
     * @return
     */
    @RequestMapping({"/list.do"})
    public ModelAndView getPressureList(@RequestParam(value = "barcode",required = false)String barcode) {
        return new ModelAndView("pressure-list").addObject("barcode", barcode);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping({"/delete.do"})
    public ModelAndView delete(@RequestParam("id") String id) {
        pressureService.doDelete(id);
        return getPressureList(null);
    }

}
