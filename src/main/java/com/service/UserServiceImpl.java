package com.service;

import com.dao.UserDAO;
import com.dao.impl.RoleDAOImpl;
import com.dao.impl.UserDAOImpl;
import com.entity.RoleEntity;
import com.entity.UserEntity;

import java.util.List;

/**
 * Created by 10922 on 2018/1/2.
 */
public class UserServiceImpl implements UserService{

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean addUser(UserEntity userEntity) {
        this.userDAO.addUser(userEntity);
        return true;
    }

    @Override
    public String login(UserEntity userEntity) {
        /**
         *@描述 实现登录功能，返回用户类型
         *@参数 [userEntity]
         *@返回值 java.lang.String
         *@创建人 zzh
         *@创建时间 2018/1/2
         *@修改人和其它时间
        **/
        //查找用户
        List<UserEntity> users = this.userDAO.getUser(userEntity);
        if (users.size()!=1)
            return "error";
        // 返回用户的角色类型
        int rid = users.get(0).getRid();
        RoleDAOImpl roleDAO = new RoleDAOImpl();
        List<RoleEntity> roles = roleDAO.getRole(new RoleEntity(rid));
        if(roles.size()!=1)
            return "error";
        else
            return roles.get(0).getRname();
    }

    @Override
    public List getAllUser() {
        UserEntity userEntity  = new UserEntity();
        return this.userDAO.getUser(userEntity);
    }

    @Override
    public List getUserById(int id) {
        return this.userDAO.getUser(new UserEntity(id));
    }

    @Override
    public boolean updateUser(UserEntity userEntity) {
        this.userDAO.updateUser(userEntity);
        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        this.userDAO.updateUser(new UserEntity(id));
        return true;
    }
}