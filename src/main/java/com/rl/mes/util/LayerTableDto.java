package com.rl.mes.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * layer组件table模块返回数据对象
 */
@Setter
@Getter
public class LayerTableDto<T> {
    /**
     * 返回码
     */
    private int code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 总条数
     */
    private long count;

    /**
     * 数据
     */
    private List<T> data;
}
