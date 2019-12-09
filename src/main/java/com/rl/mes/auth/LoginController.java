package com.rl.mes.auth;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登陆控制器
 */
@Controller
public class LoginController {


    @RequestMapping({"/toLogin"})
    public ModelAndView toLogin(){
        return  new ModelAndView("login").addObject("msg","");

    }

    @RequestMapping({"/login"})
    public ModelAndView login(@Param("account") String account, @Param("password") String password){
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
        // 登录后存放进shiro token
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
        }catch (AuthenticationException a){
            String msg = a.getMessage();
            return new ModelAndView("login").addObject("msg",msg);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping({"/logout"})
    public ModelAndView logout(){
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
        return new ModelAndView("redirect:/toLogin");
    }

    @RequestMapping("/unauthorized.do")
    public String test(){
        return "page-403";
    }

}
