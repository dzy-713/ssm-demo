package com.rl.mes.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rl.mes.pojo.ServerListen;
import com.rl.mes.service.ServerListenService;
import com.rl.mes.util.LayerTableDto;
import com.wordnik.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 服务监听接口
 */
@RestController
@RequestMapping("/api/server-listen")
public class ServerListenApi {

    @Autowired
    private ServerListenService serverListenService;


    /**
     * 获取服务列表
     * @param page 页码
     * @param limit 分页大小
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public LayerTableDto getUserList(@RequestParam(value = "page")int page,
                                     @RequestParam(value = "limit")int limit) {
        LayerTableDto<ServerListen> dto = new LayerTableDto();
        PageHelper.startPage(page,limit);
        List<ServerListen> list = serverListenService.getAllServerListen();
        PageInfo<ServerListen> pageInfo = new PageInfo<>(list);
        dto.setCount(pageInfo.getTotal());
        dto.setData(list);
        return dto;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping({"/delete"})
    public String delete(@RequestParam("id") String id) {
        serverListenService.doDelete(id);
        return "success";
    }

    /**
     * 保存
     * @param serverListen
     * @return
     */
    @RequestMapping({"/save"})
    public String save(@RequestBody ServerListen serverListen) {
        serverListenService.doSave(serverListen);
        return "success";
    }
}
