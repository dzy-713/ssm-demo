package com.rl.mes.dao;

import com.rl.mes.pojo.Fun;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 功能检测查询
 *
 */
public interface FunMapper {

    /**
     * 查询
     *
     * @param map map
     * @return 功能检测列表
     */
    List<Fun> search(@Param("map") Map<String, Object> map);


    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    Fun findById(@Param("id") String id);


    /**
     * 插入
     *
     * @param fun
     */
    void insert(Fun fun);

    /**
     * 更新
     *
     * @param fun
     */
    void update(Fun fun);

    /**
     * 删除
     *
     * @param id
     */
    void delete(@Param("id") String id);


}
