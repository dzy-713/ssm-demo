package com.rl.mes.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


/**
 * 用户实体
 */
@Setter
@Getter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    Long id;
    /**
     * 用户姓名
     */
    String name;
    /**
     * 账号
     */
    String account;
    /**
     * 密码
     */
    String password;
    /**
     * 允许登陆
     */
    Boolean allowLogin;
    /**
     * 邮箱
     */
    String email;

}
