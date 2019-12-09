package com.rl.mes.api;

import com.rl.mes.pojo.Menu;
import com.rl.mes.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 菜单
 */

@RestController
@RequestMapping("/api/menu")
public class MenuApi {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> getMenuList() {
        List<Menu> topMenu = menuService.getTopMenu();
        return menuService.getAllMenu(topMenu);
    }


}
