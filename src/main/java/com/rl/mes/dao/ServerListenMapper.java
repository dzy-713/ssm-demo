package com.rl.mes.dao;

import com.rl.mes.pojo.EmailSetting;
import com.rl.mes.pojo.ServerListen;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 服务监听查询
 *
 */
public interface ServerListenMapper {

    /**
     * 获取监听服务
     *
     * @return
     */
    ServerListen getServerListen(@Param(value = "id") String id);

    /**
     * 获取所有监听服务
     *
     * @return
     */
    List<ServerListen> getAll();

    /**
     * 插入
     *
     * @param serverListen
     */
    void insert(ServerListen serverListen);

    /**
     * 更新
     *
     * @param serverListen
     */
    void update(ServerListen serverListen);


    /**
     * 删除
     *
     * @param id
     */
    void delete(@Param(value = "id") String id);
}
