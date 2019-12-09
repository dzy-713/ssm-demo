package com.rl.mes.dao;

import com.rl.mes.pojo.Burn;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 烧录查询
 *
 * @Author: douzy
 */
public interface BurnMapper {

    /**
     * 查询
     *
     * @param map map
     * @return 烧录列表
     */
    List<Burn> search(@Param("map") Map<String, Object> map);


    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    Burn findById(@Param("id") String id);


    /**
     * 插入
     *
     * @param burn
     */
    void insert(Burn burn);

    /**
     * 更新
     *
     * @param burn
     */
    void update(Burn burn);

    /**
     * 删除
     *
     * @param id
     */
    void delete(@Param("id") String id);

    /**
     * 查询测试时间最大的一条数据
     *
     * @return
     */
    Burn findLastData();


}
