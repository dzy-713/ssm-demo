package com.rl.mes.dao;

import com.rl.mes.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户查询
 *
 */
public interface UserMapper {

    /**
     * 查询
     *
     * @param map map
     * @return 用户列表
     */
    List<User> search(@Param("map") Map<String, Object> map);

    /**
     * 分页查询
     *
     * @param map       查询过滤条件
     * @param pageBegin 查询页
     * @param pageSize  页大小
     * @return
     */
    List<User> searchByLimit(@Param("map") Map<String, Object> map,
                             @Param("pageBegin") int pageBegin,
                             @Param("pageSize") int pageSize);

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    User findById(@Param("id") String id);


    /**
     * 按账号查询，过滤id=参数id的数据  查重使用
     * @param account
     * @param id
     * @return
     */
    User findByAccount(@Param("account") String account,@Param("id") String id);

    /**
     * 插入
     *
     * @param User
     */
    void insert(User User);

    /**
     * 更新
     *
     * @param User
     */
    void update(User User);

    /**
     * 删除
     *
     * @param id
     */
    void delete(@Param("id") String id);

    /**
     * 删除角色下的角色关联
     *
     * @param user
     */
    void deleteUserRole(@Param("user") String user);

    /**
     * 保存用户和角色的关联关系
     *
     * @param user     用户id
     * @param roleList 角色id集合
     */
    void saveUserRole(@Param("user") String user, @Param("roleList") List<Integer> roleList);

    /**
     * 获取用户关联资源权限
     *
     * @param userAccount 用户账号
     * @return
     */
    List<String> getUserPermission(@Param("userAccount") String userAccount);

}
