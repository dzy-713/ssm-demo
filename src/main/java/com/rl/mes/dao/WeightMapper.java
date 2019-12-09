package com.rl.mes.dao;

import com.rl.mes.pojo.Weight;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 称重检查查询
 *
 */
public interface WeightMapper {

    /**
     * 查询
     *
     * @param map map
     * @return 称重检查列表
     */
    List<Weight> search(@Param("map") Map<String, Object> map);


    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    Weight findById(@Param("id") String id);


    /**
     * 插入
     *
     * @param weight
     */
    void insert(Weight weight);

    /**
     * 更新
     *
     * @param weight
     */
    void update(Weight weight);

    /**
     * 删除
     *
     * @param id
     */
    void delete(@Param("id") String id);


}
