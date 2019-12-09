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
public class ZTreeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public ZTreeDto(){
    }

    public ZTreeDto(Menu menu){
        this.id=menu.getId();
        this.name=menu.getName();
        this.pId=menu.getParentMenu()!=null?menu.getParentMenu().getId():null;
    }

    /**
     * 主键id
     */
    Long id;
    /**
     * 父级id
     */
    Long pId;
    /**
     * 节点名
     */
    String name;
    /**
     * 是否选中
     */
    Boolean checked;
    /**
     * 是否打开
     */
    Boolean open;
    /**
     * 子菜单
     */
    List<ZTreeDto> children;
}
