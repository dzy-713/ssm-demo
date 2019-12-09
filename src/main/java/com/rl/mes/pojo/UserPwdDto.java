package com.rl.mes.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * 用户修改密码实体
 *
 */
@Setter
@Getter
public class UserPwdDto implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 账号
     */
    String account;
    /**
     * 新密码
     */
    String password;
    /**
     * 旧密码
     */
    String oldPwd;


}
