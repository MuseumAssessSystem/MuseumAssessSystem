package com.dao;

import com.entity.UserEntity;

/**
 * Created by 10922 on 2017/12/29.
 */
public interface UserDAO{
    boolean addUser(UserEntity userEntity);
    boolean deleteUser(UserEntity userEntity);
    boolean modifyUser(UserEntity userEntity);
    //to do..
}
