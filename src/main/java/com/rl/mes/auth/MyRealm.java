package com.rl.mes.auth;

import com.rl.mes.pojo.User;
import com.rl.mes.service.LicenseService;
import com.rl.mes.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private LicenseService licenseService;

    @Override
    public String getName() {
        return "myrealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 权限认证
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) getAvailablePrincipal(principals);
        //通过用户名从数据库获取权限字符串
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取用户权限
        List<String> permissionList = userService.getUserPermission(username);
        //权限
        Set<String> s;
        if (permissionList != null) {
            s = new HashSet<>(permissionList);
        } else {
            s = new HashSet<>();
        }

        info.setStringPermissions(s);
        //角色
        //Set<String> r = new HashSet<String>();
        //r.add("role1");
        //info.setRoles(r);

        return info;
    }

    /**
     * 登陆认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //得到用户名
        String username = (String) token.getPrincipal();
        //得到密码
        String password = new String((char[]) token.getCredentials());
        try {
            //用户认证
            User user = userService.valid(username, password);
            //授权认证
            licenseService.valid();

        } catch (Exception e) {
            throw new AuthenticationException(e.getMessage());
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }

}