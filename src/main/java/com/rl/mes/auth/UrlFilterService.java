package com.rl.mes.auth;

import com.rl.mes.pojo.Menu;
import com.rl.mes.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 */
@Service
public class UrlFilterService {

    @Autowired
    private MenuService menuService;

    public UrlFilter createUrlFilter(UrlFilter urlFilter) {
        //urlFilterDao.createUrlFilter(urlFilter);
        //initFilterChain();
        return urlFilter;
    }


    public UrlFilter updateUrlFilter(UrlFilter urlFilter) {
        return urlFilter;
    }

    public void deleteUrlFilter(Long urlFilterId) {

    }

    public UrlFilter findOne(Long urlFilterId) {
        return null;
    }

    public List<UrlFilter> findAll() {
        List<UrlFilter> list = new ArrayList<>();
        List<Menu> menuList = menuService.getAllMenu(menuService.getTopMenu());
        for (Menu menu : menuList) {
            UrlFilter urlFilter = new UrlFilter();
            urlFilter.setId(menu.getId());
            urlFilter.setUrl(StringUtils.isEmpty(menu.getUrl())?"\\shiro":menu.getUrl());
            urlFilter.setName(menu.getPermission());
            urlFilter.setPermissions(menu.getPermission());
            urlFilter.setRoles("");
            list.add(urlFilter);
        }
        return list;
    }

//    //其他方法请参考源码
//    @PostConstruct
//    public void initFilterChain() {
//        ShiroFilerChainManager shiroFilerChainManager;
//        shiroFilerChainManager.initFilterChains(findAll());
//    }

}
