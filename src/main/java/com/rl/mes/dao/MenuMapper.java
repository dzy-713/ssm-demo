package com.rl.mes.dao;

import com.rl.mes.pojo.Menu;
import com.rl.mes.pojo.ZTreeDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 */
public interface MenuMapper {

    /**
     * 查询
     *
     * @param map map
     * @return 菜单列表
     */
    List<Menu> search(@Param("map") Map<String, Object> map);

    /**
     * 获取顶级菜单
     *
     * @return
     */
    List<Menu> getTopMenu();

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    Menu findById(@Param("id") String id);

    /**
     * 查询下级
     *
     * @param parentMenuId
     * @return
     */
    List<Menu> selectWithParent(@Param("parentMenuId") String parentMenuId);

    /**
     * 插入
     *
     * @param menu
     */
    void insert(Menu menu);

    /**
     * 更新
     *
     * @param menu
     */
    void update(Menu menu);

    /**
     * 删除
     *
     * @param id
     */
    void delete(@Param("id") String id);

    Menu getMenuInfo();

    /**
     * 获取角色关联的菜单树
     *
     * @param id
     */
    List<ZTreeDto> getMenuByRole(@Param("id") String id);

}
