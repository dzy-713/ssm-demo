package com.rl.mes.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单实体
 */
@Setter
@Getter
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    Long id;
    /**
     * 菜单名
     */
    String name;
    /**
     * 父级菜单
     */
    Menu parentMenu;
    /**
     * 菜单类型 组，链接，功能
     */
    String type;
    /**
     * URL
     */
    String url;
    /**
     * 图标
     */
    String image;
    /**
     * 权限编码
     */
    String permission;
    /**
     * 排序
     */
    Integer orderliness;
    /**
     * 层级
     */
    Integer level;
    /**
     * 是否末级
     */
    Boolean end;
    /**
     * 子菜单
     */
    List<Menu> childList;
}
