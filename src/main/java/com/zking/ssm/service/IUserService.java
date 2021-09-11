package com.zking.ssm.service;

import com.zking.ssm.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface IUserService {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(User user);

    /**
     * 获取用户角色名
     * @param userName
     * @return
     */
    Set<String> getRole(String userName);

    /**
     * 获取用户权限
     * @param userName
     * @return
     */
    Set<String> getPermission(String userName);
}