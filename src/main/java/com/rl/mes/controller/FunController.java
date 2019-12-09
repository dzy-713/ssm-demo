package com.rl.mes.controller;

import com.rl.mes.service.FunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 功能测试控制器
 *
 */
@Controller
@RequestMapping("/fun")
public class FunController {

    @Autowired
    private FunService funService;


    /**
     * 获取功能测试列表---layer组件
     *
     * @return
     */
    @RequestMapping({"/list.do"})
    public ModelAndView getFunList(@RequestParam(value = "barcode",required = false)String barcode) {
        return new ModelAndView("fun-list").addObject("barcode",barcode);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping({"/delete.do"})
    public ModelAndView delete(@RequestParam("id") String id) {
        funService.doDelete(id);
        return getFunList(null);
    }

}
