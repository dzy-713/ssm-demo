package com.rl.mes.dao;

import com.rl.mes.pojo.PickData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 采集数据查询
 *
 */
public interface PickDataMapper {

    /**
     * 查询
     *
     * @param barcode 条码
     * @return 功能检测列表
     */
    List<PickData> getListByBarcode(@Param("barcode") String barcode);


}
