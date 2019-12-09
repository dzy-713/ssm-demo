package com.rl.mes.controller;

import com.rl.mes.pojo.EmailSetting;
import com.rl.mes.service.EmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 邮箱设置控制器
 *
 */
@Controller
@RequestMapping("/email-setting")
public class EmailSettingController {

    @Autowired
    private EmailSettingService emailSettingService;


    /**
     * 打开编辑页面
     *
     * @return
     */
    @RequestMapping({"/edit.do"})
    public ModelAndView editPage() {
        EmailSetting emailSetting = emailSettingService.getEmailSetting();
        if (emailSetting == null) {
            emailSetting = new EmailSetting();
        }
        return new ModelAndView("email-setting-edit").addObject("emailSetting", emailSetting);
    }

}
