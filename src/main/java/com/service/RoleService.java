package com.service;

import com.entity.RoleEntity;

import java.util.List;

/**
 * Created by 10922 on 2018/1/4.
 */
public interface RoleService {
    RoleEntity getRoleById(int rid);
    List<RoleEntity> getAllRole();
    List<RoleEntity> getRoleByName(String rname);
}
