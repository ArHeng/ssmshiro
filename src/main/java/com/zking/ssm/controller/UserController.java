package com.zking.ssm.controller;

import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserService;
import com.zking.ssm.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/handleUser")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/godel")
    public String goDel(){
        return "delete";
    }

    /**
     * 增加
     * @param u
     * @return
     */
    @RequestMapping("/add")
    public String save(User u){
        String salt = PasswordHelper.createSalt();
        String pwd = PasswordHelper.createCredentials(u.getPassword(), salt);
        u.setPassword(pwd);
        u.setSalt(salt);

        int n = userService.insert(u);

        if(n>0){
            return "success";
        }else{
            return "failed";
        }
    }

    /**
     * 删除
     * @param uid
     * @return
     */
    @RequestMapping("/delete")
    public Map<String,Object> del(Integer uid){
        int n = userService.deleteByPrimaryKey(uid);
        String msg="删除成功！";
        if(n<=0){
            msg="删除失败！";
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",n);
        map.put("msg",msg);
        return map;
    }

}
