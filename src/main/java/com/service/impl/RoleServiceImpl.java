package com.service.impl;

import com.dao.RoleDAO;
import com.dao.impl.RoleDAOImpl;
import com.entity.RoleEntity;
import com.service.RoleService;

/**
 * Created by 10922 on 2018/1/4.
 */
public class RoleServiceImpl implements RoleService{
    @Override
    public RoleEntity getRoleById(int rid) {
        RoleDAO roleDAO = new RoleDAOImpl();
        return roleDAO.getRole(new RoleEntity(rid)).get(0);
    }
}
