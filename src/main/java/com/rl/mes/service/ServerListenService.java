package com.rl.mes.service;

import com.rl.mes.dao.ServerListenMapper;
import com.rl.mes.pojo.ServerListen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 服务service
 *
 */
@Service
public class ServerListenService {

    @Autowired
    private ServerListenMapper serverListenMapper;


    /**
     * 获取服务列表
     *
     * @return
     */
    public List<ServerListen> getAllServerListen() {
        return serverListenMapper.getAll();
    }



    /**
     * 通过id获取服务详情
     *
     * @param id
     * @return
     */
    public ServerListen getServerListenById(String id) {
        return serverListenMapper.getServerListen(id);
    }


    /**
     * 保存or更新
     *
     * @param ServerListen
     */
    public void doSave(ServerListen ServerListen) {
        if (StringUtils.isEmpty(ServerListen.getId())) {
            serverListenMapper.insert(ServerListen);
        } else {
            serverListenMapper.update(ServerListen);
        }
    }


    /**
     * 删除
     *
     * @param id
     */
    public void doDelete(String id) {
        serverListenMapper.delete(id);
    }

}
