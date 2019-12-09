package com.rl.mes.controller;

import com.rl.mes.pojo.Menu;
import com.rl.mes.pojo.User;
import com.rl.mes.service.MenuService;
import com.rl.mes.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 主页
 */
@Controller
public class IndexController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userService;

    public IndexController() {
    }

    @RequestMapping({"/"})
    public ModelAndView execute() {
        //获取登录用户
        String account = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getUserByAccount(account);
        //获取菜单
        List<Menu> menuList = menuService.getTopMenu();
        String menuHTML = menuService.getMenuHTML(menuList, true);
        return new ModelAndView("index")
                .addObject("menuHTML", menuHTML)
                .addObject("account", user.getAccount())
                .addObject("userName", user.getName());
    }
}