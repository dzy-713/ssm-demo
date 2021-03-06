package com.rl.mes.controller;

import com.rl.mes.service.BurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 投单工站控制器
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private BurnService burnService;


    /**
     * 获取投单工站列表---layer组件
     *
     * @return
     */
    @RequestMapping({"/list.do"})
    public ModelAndView getBurnList(@RequestParam(value = "barcode",required = false)String barcode) {
        return new ModelAndView("order-list").addObject("barcode", barcode);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping({"/delete.do"})
    public ModelAndView delete(@RequestParam("id") String id) {
        burnService.doDelete(id);
        return getBurnList(null);
    }

}
