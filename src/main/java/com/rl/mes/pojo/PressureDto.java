package com.rl.mes.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 压力测试实体类
 *
 */
@Getter
@Setter
public class PressureDto implements Serializable {

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
     * Ag 重量
     */
    Integer agWeight;
    /**
     * Ag 测试结果
     */
    String agTestResult;
    /**
     * Ag 压力
     */
    Integer agAvgPressure;

    /**
     * Bg 重量
     */
    Integer bgWeight;
    /**
     * Bg 测试结果
     */
    String bgTestResult;
    /**
     * Bg 压力
     */
    Integer bgAvgPressure;


    /**
     * Cg 重量
     */
    Integer cgWeight;
    /**
     * Cg 测试结果
     */
    String cgTestResult;
    /**
     * Cg 压力
     */
    Integer cgAvgPressure;

    /**
     * 工站
     */
    String station;

    /**
     * 通过
     */
    String pass;
}
