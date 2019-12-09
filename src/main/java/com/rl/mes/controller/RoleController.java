package com.rl.mes.controller;

import com.alibaba.fastjson.JSON;
import com.rl.mes.pojo.Role;
import com.rl.mes.pojo.ZTreeDto;
import com.rl.mes.service.MenuService;
import com.rl.mes.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 角色控制器
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    /**
     * 获取角色列表
     *
     * @return
     */
    @RequestMapping({"/list.do"})
    public ModelAndView getRoleList() {
        List<Role> roles = roleService.getAllRole();
        return new ModelAndView("role-list").addObject("roles", roles);
    }


    /**
     * 打开编辑页面
     *
     * @param id 角色id
     * @return
     */
    @RequestMapping({"/edit.do"})
    public ModelAndView editPage(@Param("id") String id) {
        Role role = roleService.getRoleById(id);
        //获取资源树json数据
        List<ZTreeDto> zTreeDtos = menuService.getMenuTree(role);
        return new ModelAndView("role-edit").addObject("role", role).addObject("treeData", JSON.toJSONString(zTreeDtos));
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping({"/delete.do"})
    public ModelAndView delete(@RequestParam("id") String id) {
        roleService.doDelete(id);
        return getRoleList();
    }
}
