package com.rl.mes.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 外观检测实体类
 *
 */
@Setter
@Getter
public class ExteriorDto implements Serializable {

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
     * 检测结果
     */
    String result;

    /**
     * 工站
     */
    String station;

    /**
     * 通过
     */
    String pass;
}
