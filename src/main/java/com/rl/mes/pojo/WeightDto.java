package com.rl.mes.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 称重检查实体类
 *
 */
@Getter
@Setter
public class WeightDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    Long id;
    /**
     * 条码
     */
    String barcode;
    /**
     * 工号
     */
    String worker;
    /**
     * 测试时间
     */
    String testTime;

    /**
     * 重量
     */
    String weight;

    /**
     * 工站
     */
    String station;

    /**
     * 通过
     */
    String pass;
}
