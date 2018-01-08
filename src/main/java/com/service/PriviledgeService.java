package com.service;

import com.entity.PriviledgeEntity;
import com.entity.RoleEntity;

import java.util.List;

/**
 * Created by 10922 on 2018/1/8.
 */
public interface PriviledgeService {
    List<PriviledgeEntity> getRolePriveledge(RoleEntity roleEntity);
    void updateRolePriviledge(RoleEntity roleEntity);
}
