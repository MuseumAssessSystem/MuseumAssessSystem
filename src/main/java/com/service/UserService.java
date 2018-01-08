package com.service;

import com.entity.PriviledgeEntity;
import com.entity.UserEntity;

import java.util.List;

/**
 * Created by 10922 on 2018/1/2.
 */
public interface UserService {
    boolean addUser(UserEntity userEntity);
    String login(UserEntity userEntity);
    List getAllUser();
    List getUserById(int id);
    boolean updateUser(UserEntity userEntity);
    boolean deleteUser(int id);
    List<UserEntity> getUserByUname(String uname);

}
