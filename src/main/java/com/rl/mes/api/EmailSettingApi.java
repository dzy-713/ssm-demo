package com.rl.mes.api;

import com.rl.mes.pojo.EmailSetting;
import com.rl.mes.service.EmailSettingService;
import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 邮箱设置接口
 */
@RestController
@RequestMapping("/api/email-setting")
public class EmailSettingApi {

    @Autowired
    private EmailSettingService emailSettingService;

    /**
     * 保存
     * @param emailSetting
     * @return
     */
    @RequestMapping({"/save"})
    public String save(@RequestBody EmailSetting emailSetting) {
        emailSettingService.doSave(emailSetting);
        return "success";
    }

}
