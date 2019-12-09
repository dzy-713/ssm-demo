package com.rl.mes.service;

import com.rl.mes.dao.MenuMapper;
import com.rl.mes.pojo.Menu;
import com.rl.mes.pojo.Role;
import com.rl.mes.pojo.ZTreeDto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 获取菜单HTML元素字符串
     *
     * @return
     */
    public String getMenuHTML(List<Menu> list, Boolean root) {
        StringBuffer menuStr = new StringBuffer();
        if (root) {
            menuStr.append("<ul class='nav side-menu'>");
        } else {
            menuStr.append("<ul class='nav child_menu'>");
        }
        for (Menu menu : list) {
            //菜单权限过滤
            try {
                SecurityUtils.getSubject().checkPermission(menu.getPermission());
            } catch (AuthorizationException e) {
                continue;
            }catch (IllegalArgumentException e){
                continue;
            }
            menuStr.append("<li>");
            if ("folder".equals(menu.getType())) {
                menuStr.append("<a>");
                menuStr.append("<i class='" + menu.getImage() + "'></i> " + menu.getName() + " <span class='fa fa-chevron-down'></span></a>");
                if (menu.getChildList() != null && menu.getChildList().size() > 0) {
                    menuStr.append(getMenuHTML(menu.getChildList(), false));
                }
            } else {
                menuStr.append("<a href='javascript:;'");
                menuStr.append("onclick='openMenu(\"" + menu.getUrl() + "\",\"" + menu.getName() + "\",\"" + menu.getId() + "\")'>");
                menuStr.append("<i class='" + menu.getImage() + "'></i> " + menu.getName());
                menuStr.append("</a>");
            }
            menuStr.append("</li>");
        }
        menuStr.append("</ul>");
        return menuStr.toString();
    }

    public List<Menu> getTopMenu() {
        List<Menu> list = menuMapper.getTopMenu();
        return list;
    }

    public List<Menu> getAllMenu(List<Menu> topMenus) {
        List<Menu> list = new ArrayList();
        for (Menu menu : topMenus) {
            list.add(menu);
            if ("folder".equals(menu.getType()) || "link".equals(menu.getType())) {
                if (menu.getChildList() != null && menu.getChildList().size() > 0) {
                    list.addAll(getAllMenu(menu.getChildList()));
                }
            }
        }
        return list;
    }

    public Menu getMenuById(String id) {
        return menuMapper.findById(id);
    }

    public void doSave(Menu menu) {
        //获取父级
        Menu parent = menu.getParentMenu();
        if (parent != null && !StringUtils.isEmpty(parent.getId())) {
            parent = menuMapper.findById(parent.getId().toString());
        } else {
            parent = null;
        }
        //处理层级关系
        if (parent != null) {
            menu.setLevel(parent.getLevel() + 1);
            parent.setEnd(false);
            menuMapper.update(parent);
        } else {
            menu.setLevel(1);
        }
        menu.setEnd(true);
        if (StringUtils.isEmpty(menu.getId())) {
            menuMapper.insert(menu);
        } else {
            menuMapper.update(menu);
        }
    }

    public void doDelete(String id) {
        Menu menu = menuMapper.findById(id);
        Menu parent = menu.getParentMenu();
        menuMapper.delete(id);
        if (parent != null && parent.getChildList().size() == 0) {
            parent.setEnd(false);
        }
    }

    /**
     * 获取角色下的权限树
     *
     * @param role 角色
     * @return
     */
    public List<ZTreeDto> getMenuTree(Role role) {
        List<Menu> list;
        List<ZTreeDto> zTreeDtos = new ArrayList<>();
        if (role == null || StringUtils.isEmpty(role.getId())) {
            list = getAllMenu(getTopMenu());
            for (Menu menu : list) {
                ZTreeDto dto = new ZTreeDto(menu);
                zTreeDtos.add(dto);
            }
        } else {
            zTreeDtos = menuMapper.getMenuByRole(role.getId().toString());
        }
        return zTreeDtos;
    }
}
