package com.dao;

import com.entity.RoleEntity;

import java.util.List;

/**
 * Created by 10922 on 2018/1/2.
 */
public interface RoleDAO {


    void addRole(RoleEntity roleEntity);
    void deleteRole(RoleEntity roleEntity);
    void updateRole(RoleEntity roleEntity);
    List getRole(RoleEntity roleEntity);
}
