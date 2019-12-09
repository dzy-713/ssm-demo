package com.rl.mes.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * 角色实体
 */
@Setter
@Getter
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    Long id;
    /**
     * 名称
     */
    String name;
    /**
     * 编码
     */
    String code;

}
