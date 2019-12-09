package com.rl.mes.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


/**
 * 角色实体
 */
@Setter
@Getter
public class RoleDto implements Serializable {

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
    /**
     * 是否更新关联资源权限
     */
    Boolean updatePermission;
    /**
     * 资源权限集合
     */
    List<Integer> permissionList;


}
