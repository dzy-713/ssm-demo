package com.rl.mes.dao;

import com.rl.mes.pojo.EmailSetting;

/**
 * 邮箱配置查询
 *
 */
public interface EmailSettingMapper {

    /**
     * 获取邮箱设置
     *
     * @return
     */
    EmailSetting getEmailSetting();

    /**
     * 插入
     *
     * @param emailSetting
     */
    void insert(EmailSetting emailSetting);

    /**
     * 更新
     *
     * @param emailSetting
     */
    void update(EmailSetting emailSetting);


}
