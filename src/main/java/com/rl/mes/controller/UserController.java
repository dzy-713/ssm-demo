package com.rl.mes.controller;

import com.alibaba.fastjson.JSON;
import com.rl.mes.pojo.User;
import com.rl.mes.pojo.UserDto;
import com.rl.mes.pojo.ZTreeDto;
import com.rl.mes.service.RoleService;
import com.rl.mes.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 用户控制器
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    /**
     * 获取用户列表---layer组件
     *
     * @return
     */
    @RequestMapping({"/list.do"})
    public ModelAndView getUserList() {
        List<User> users = userService.getAllUser();
        return new ModelAndView("user-list").addObject("users", users);
    }

    /**
     * 打开编辑页面
     *
     * @param id 用户id
     * @return
     */
    @RequestMapping({"/edit.do"})
    public ModelAndView editPage(@Param("id") String id) {
        if (!StringUtils.isEmpty(id)) {
            User user = userService.getUserById(id);
            List<ZTreeDto> zTreeDtos = roleService.getRoleTree(id);
            return new ModelAndView("user-edit").addObject("user", user).addObject("treeData", JSON.toJSONString(zTreeDtos));
        } else {
            List<ZTreeDto> zTreeDtos = roleService.getRoleTree(id);
            return new ModelAndView("user-edit").addObject("treeData", JSON.toJSONString(zTreeDtos));
        }
    }

    /**
     * 打开密码修改页面
     *
     * @param account 用户账号
     * @return
     */
    @RequestMapping({"/editPwd.do"})
    public ModelAndView editPwdPage(@Param("account") String account) {
        User user = userService.getUserByAccount(account);
        return new ModelAndView("user-pwd").addObject("user", user);
    }



    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping({"/delete.do"})
    public ModelAndView delete(@RequestParam("id") String id) {
        userService.doDelete(id);
        return getUserList();
    }

}
