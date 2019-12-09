package com.rl.mes.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * 监听服务实体
 *
 */
@Setter
@Getter
public class ServerListen implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    Long id;
    /**
     * 服务名称
     */
    String name;
    /**
     * url
     */
    String url;
    /**
     * 请求方式
     */
    String method;
    /**
     * 请求间隔(s)
     */
    Integer reqCycle;
    /**
     * 开启监听
     */
    Boolean isListen;
    /**
     * 接口状态
     */
    String stateInfo;

}
