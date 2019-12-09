package com.rl.mes.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 */
@Setter
@Getter
public class Burn implements Serializable {

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
     * 工单号
     */
    String workOrderNum;
    /**
     * 成品料号
     */
    String partNum;
    /**
     * 测试时间
     */
    Date testTime;
    /**
     * ADC0
     */
    String adc0;
    /**
     * ADC10_15
     */
    String adc10_15;
    /**
     * ADC350
     */
    String adc350;
    /**
     * MaxCodes
     */
    String maxCodes;

    /**
     * 工站
     */
    String station;

    /**
     * 通过
     */
    String pass;
}
