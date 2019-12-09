package com.rl.mes.service;

import com.rl.mes.dao.EmailSettingMapper;
import com.rl.mes.pojo.EmailSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 邮箱设置service
 *
 */
@Service
public class EmailSettingService {

    @Autowired
    private EmailSettingMapper emailSettingMapper;


    /**
     * 获取邮箱设置详情
     *
     * @return
     */
    public EmailSetting getEmailSetting() {
        return emailSettingMapper.getEmailSetting();
    }


    /**
     * 保存or更新
     *
     * @param emailSetting
     */
    public void doSave(EmailSetting emailSetting) {
        if(getEmailSetting()==null){
            emailSettingMapper.insert(emailSetting);
        }
        else {
            emailSettingMapper.update(emailSetting);
        }
    }

}
