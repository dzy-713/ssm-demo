package com.rl.mes.controller;

import com.rl.mes.pojo.ServerListen;
import com.rl.mes.service.ServerListenService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 服务监听控制器
 *
 */
@Controller
@RequestMapping("/server-listen")
public class ServerListenController {

    @Autowired
    private ServerListenService serverListenService;


    /**
     * 获取列表---layer组件
     * @return
     */
    @RequestMapping({"/list.do"})
    public ModelAndView getServerListenList() {
        List<ServerListen> serverListens = serverListenService.getAllServerListen();
        return new ModelAndView("server-listen-list").addObject("serverListens", serverListens);
    }

    /**
     * 打开编辑页面
     * @param id
     * @return
     */
    @RequestMapping({"/edit.do"})
    public ModelAndView editPage(@Param("id") String id) {
        if (!StringUtils.isEmpty(id)) {
            ServerListen serverListen = serverListenService.getServerListenById(id);
            return new ModelAndView("server-listen-edit").addObject("serverListen", serverListen);
        }else{
            return new ModelAndView("server-listen-edit");
        }
    }

    /**
     * 保存
     * @param serverListen
     * @return
     */
    @RequestMapping({"/save.do"})
    public ModelAndView save(ServerListen serverListen) {
        serverListenService.doSave(serverListen);
        return getServerListenList();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping({"/delete.do"})
    public ModelAndView delete(@RequestParam("id") String id) {
        serverListenService.doDelete(id);
        return getServerListenList();
    }

}
