package com.zking.ssm.controller;

import com.zking.ssm.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/do")
    public String doLogin(HttpSession session,User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());

        String message="";
        try {
            subject.login(token);
            message="登陆成功";
            /*if(subject.hasRole("管理员")){
                return "admin";
            }else if(subject.hasRole("高级用户")){
                return "good";
            }else{
                return "index";
            }*/


        } catch (IncorrectCredentialsException e) {
            message="密码错误";
        } catch (UnknownAccountException e1) {
            message="账户不存在";
        }

        session.setAttribute("message",message);
        return "main";
    }
}
