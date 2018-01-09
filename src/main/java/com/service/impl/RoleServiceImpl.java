package com.service.impl;

import com.dao.RoleDAO;
import com.dao.impl.RoleDAOImpl;
import com.entity.RoleEntity;
import com.service.RoleService;

import java.util.List;

/**
 * Created by 10922 on 2018/1/4.
 */
public class RoleServiceImpl implements RoleService{
    @Override
    public RoleEntity getRoleById(int rid) {
        RoleDAO roleDAO = new RoleDAOImpl();
        return roleDAO.getRole(new RoleEntity(rid)).get(0);
    }

    @Override
    public List<RoleEntity> getAllRole() {
        RoleDAO roleDAO = new RoleDAOImpl();
        return roleDAO.getRole(new RoleEntity());
    }

    @Override
    public List<RoleEntity> getRoleByName(String rname) {
        RoleDAO roleDAO = new RoleDAOImpl();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRname(rname);
        return roleDAO.getRole(roleEntity);
    }
}
