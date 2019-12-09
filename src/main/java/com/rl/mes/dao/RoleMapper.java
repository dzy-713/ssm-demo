package com.rl.mes.dao;

import com.rl.mes.pojo.Role;
import com.rl.mes.pojo.User;
import com.rl.mes.pojo.ZTreeDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 角色查询
 *
 */
public interface RoleMapper {

    /**
     * 查询
     *
     * @param map map
     * @return 角色列表
     */
    List<Role> search(@Param("map") Map<String, Object> map);


    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    Role findById(@Param("id") String id);

    /**
     * 按编码查询，过滤id=参数id的数据  查重使用
     * @param code
     * @param id
     * @return
     */
    Role findByCode(@Param("code") String code, @Param("id") String id);

    /**
     * 插入
     *
     * @param Role
     */
    void insert(Role Role);

    /**
     * 更新
     *
     * @param Role
     */
    void update(Role Role);

    /**
     * 删除
     *
     * @param id
     */
    void delete(@Param("id") String id);

    /**
     * 删除角色下所有关联信息
     * @param id 角色id
     */
    void deleteRolePermission(@Param("id") String id);

    /**
     * 保存角色下所有关联信息
     * @param id 角色id
     * @param menuList 菜单id数据
     */
    void saveRolePermission(@Param("id") String id,@Param("menuList") List<Integer> menuList);

    /**
     * 获取用户关联的角色数据
     * @param user 用户id
     * @return
     */
    List<ZTreeDto> getRoleTree(@Param("user") String user);
}
