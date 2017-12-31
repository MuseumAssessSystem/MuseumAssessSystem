package com.service;

import com.dao.impl.UserDAOImpl;
import com.entity.UserEntity;

/**
 * Created by 10922 on 2017/12/30.
 */
public class UserService {

    private UserDAOImpl userDAO;

    public boolean checkLogin(UserEntity userEntity){

        return true;
    }

    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAOImpl getUserDAO() {
        return userDAO;
    }
}
