package com.rl.mes.dao;

import com.rl.mes.pojo.Pressure;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 压力检测查询
 *
 */
public interface PressureMapper {

    /**
     * 查询
     *
     * @param map map
     * @return 压力检测列表
     */
    List<Pressure> search(@Param("map") Map<String, Object> map);


    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    Pressure findById(@Param("id") String id);


    /**
     * 插入
     *
     * @param pressure
     */
    void insert(Pressure pressure);

    /**
     * 更新
     *
     * @param pressure
     */
    void update(Pressure pressure);

    /**
     * 删除
     *
     * @param id
     */
    void delete(@Param("id") String id);


}
