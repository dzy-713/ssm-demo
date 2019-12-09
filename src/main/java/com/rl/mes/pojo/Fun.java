package com.rl.mes.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 功能测试实体类
 *
 */
@Getter
@Setter
public class Fun implements Serializable {

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
    Date testTime;
    /**
     * 划线测试
     */
    String drawLineTest;
    /**
     * 漏水测试
     */
    String leakWaterTest;
    /**
     * 上按键测试
     */
    String upBtnTest;
    /**
     * 下按键测试
     */
    String downBtnTest;

    /**
     * 工站
     */
    String station;

    /**
     * 通过
     */
    String pass;
}
