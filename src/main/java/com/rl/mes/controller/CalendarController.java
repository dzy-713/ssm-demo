package com.rl.mes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 日历
 */
@Controller
@RequestMapping("/calendar")
public class CalendarController {

    /**
     * 返回日历界面
     * @return
     */
    @RequestMapping({"/view.do"})
    public ModelAndView view() {
        return new ModelAndView("calendar");
    }
}
