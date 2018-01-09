package com.service;

import com.entity.UserEntity;

import java.util.List;

/**
 * Created by 10922 on 2018/1/2.
 */
public interface UserService {
    boolean addUser(UserEntity userEntity);
    String login(UserEntity userEntity);
    List<UserEntity> getAllUser();
    List<UserEntity> getUserById(int id);
    boolean updateUser(UserEntity userEntity);
    boolean deleteUser(int id);
    List<UserEntity> getUserByUname(String uname);

}
