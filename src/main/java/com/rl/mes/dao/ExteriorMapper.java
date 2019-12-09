package com.rl.mes.dao;

import com.rl.mes.pojo.Exterior;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 外观检查查询
 */
public interface ExteriorMapper {

    /**
     * 查询
     *
     * @param map map
     * @return 外观检查列表
     */
    List<Exterior> search(@Param("map") Map<String, Object> map);


    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    Exterior findById(@Param("id") String id);


    /**
     * 插入
     *
     * @param weight
     */
    void insert(Exterior weight);

    /**
     * 更新
     *
     * @param weight
     */
    void update(Exterior weight);

    /**
     * 删除
     *
     * @param id
     */
    void delete(@Param("id") String id);


}
