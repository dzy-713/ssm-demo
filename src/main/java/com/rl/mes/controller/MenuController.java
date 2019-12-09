package com.rl.mes.controller;

import com.rl.mes.pojo.Menu;
import com.rl.mes.service.MenuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 菜单控制器
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping({"/list.do"})
    public ModelAndView getMenuTree() {
        List<Menu> topMenu = menuService.getTopMenu();
        List<Menu> menus = menuService.getAllMenu(topMenu);
        return new ModelAndView("menu-list").addObject("menus", menus);
    }

    @RequestMapping({"/edit.do"})
    public ModelAndView editPage(@Param("id") String id, @Param("parentMenuId") String parentMenuId) {
        if (!StringUtils.isEmpty(id)) {
            Menu menu = menuService.getMenuById(id);
            return new ModelAndView("menu-edit").addObject("menu", menu);
        } else if (!StringUtils.isEmpty(parentMenuId)) {
            Menu parentMenu = menuService.getMenuById(parentMenuId);
            Menu menu = new Menu();
            menu.setParentMenu(parentMenu);
            return new ModelAndView("menu-edit").addObject("menu", menu);
        } else {
            Menu menu = new Menu();
            return new ModelAndView("menu-edit").addObject("menu", menu);
        }
    }

    @RequestMapping({"/save.do"})
    public ModelAndView save(Menu menu) {
        menuService.doSave(menu);
        return getMenuTree();
    }

    @RequestMapping({"/delete.do"})
    public ModelAndView delete(@RequestParam("id") String id) {
        menuService.doDelete(id);
        return getMenuTree();
    }
}
