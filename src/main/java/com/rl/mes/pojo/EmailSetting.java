package com.rl.mes.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * 邮箱设置实体
 */
@Setter
@Getter
public class EmailSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 邮箱服务地址 qq邮箱 smtp.qq.com
     */
    String host;
    /**
     * 绑定发送邮箱
     */
    String fromEmail;
    /**
     * 授权码
     */
    String passWord;

}
