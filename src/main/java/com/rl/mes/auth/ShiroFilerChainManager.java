package com.rl.mes.auth;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
@Service
public class ShiroFilerChainManager {

    @Autowired
    private ShiroFilterFactoryBean filterFactoryBean;
    @Autowired
    private UrlFilterService urlFilterService;

    private DefaultFilterChainManager filterChainManager;
    private PathMatchingFilterChainResolver resolver;
    private Map<String, NamedFilterList> defaultFilterChains;


    /**
     * 实例化后自动执行
     */
    @PostConstruct
    public void init() {
        try{
            resolver = (PathMatchingFilterChainResolver) ((AbstractShiroFilter) filterFactoryBean.getObject()).getFilterChainResolver();
            filterChainManager = (DefaultFilterChainManager) resolver.getFilterChainManager();
        }catch (Exception e){
            System.exit(1);
            return;
        }
        defaultFilterChains = new HashMap<String, NamedFilterList>(filterChainManager.getFilterChains());
        List<UrlFilter> urlFilters = urlFilterService.findAll();
        initFilterChains(urlFilters);
    }

    /**
     * 合并url过滤器
     * @param urlFilters
     */
    public void initFilterChains(List<UrlFilter> urlFilters) {
        //1、首先删除以前老的filter chain并注册默认的
        filterChainManager.getFilterChains().clear();
        if (defaultFilterChains != null) {
            filterChainManager.getFilterChains().putAll(defaultFilterChains);
        }
        //2、循环URL Filter 注册filter chain
        for (UrlFilter urlFilter : urlFilters) {
            String url = urlFilter.getUrl();
            //注册roles filter
            if (!StringUtils.isEmpty(urlFilter.getRoles())) {
                filterChainManager.addToChain(url, "roles", urlFilter.getRoles());
            }
            //注册perms filter
            if (!StringUtils.isEmpty(urlFilter.getPermissions())) {
                filterChainManager.addToChain(url, "perms", urlFilter.getPermissions());
            }
        }
    }
}
