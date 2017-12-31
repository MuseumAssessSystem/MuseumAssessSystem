package com.dao;

import com.entity.UserEntity;

import java.util.List;

/**
 * Created by 10922 on 2017/12/29.
 */
public interface UserDAO{
    void addUser(UserEntity userEntity);
    void deleteUser(UserEntity userEntity);
    void updateUser(UserEntity userEntity);
    List<UserEntity> getUser(UserEntity userEntity);
    //to do..
}
