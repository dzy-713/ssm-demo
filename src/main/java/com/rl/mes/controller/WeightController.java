package com.rl.mes.controller;

import com.rl.mes.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 称重检查控制器
 *
 */
@Controller
@RequestMapping("/weight")
public class WeightController {

    @Autowired
    private WeightService weightService;


    /**
     * 获取称重检查列表---layer组件
     *
     * @return
     */
    @RequestMapping({"/list.do"})
    public ModelAndView getWeightList(@RequestParam(value = "barcode",required = false)String barcode) {
        return new ModelAndView("weight-list").addObject("barcode",barcode);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping({"/delete.do"})
    public ModelAndView delete(@RequestParam("id") String id) {
        weightService.doDelete(id);
        return getWeightList(null);
    }

}
