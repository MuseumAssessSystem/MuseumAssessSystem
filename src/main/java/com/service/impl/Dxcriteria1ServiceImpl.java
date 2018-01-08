package com.service.impl;

import com.dao.Dxcriteria1DAO;
import com.dao.impl.Dxcriteria1DAOImpl;
import com.entity.Dxcriteria1Entity;
import com.service.Dxcriteria1Service;

/**
 * Created by admin on 2018/1/3.
 */
public class Dxcriteria1ServiceImpl implements Dxcriteria1Service {
    private Dxcriteria1DAO dxcriteria1DAO = new Dxcriteria1DAOImpl();
    @Override
    public Dxcriteria1Entity getDxcriteria1ByDxc1id(int dxc1id) {
        Dxcriteria1Entity dxcriteria1Entity = new Dxcriteria1Entity();
        dxcriteria1Entity.setDxc1Id(dxc1id);
       return this.dxcriteria1DAO.getDxcriteria1(dxcriteria1Entity).get(0);
    }

    @Override
    public Dxcriteria1Entity getDxcriteria1ByDxc1name(String dxc1name) {
        Dxcriteria1Entity dxcriteria1Entity = new Dxcriteria1Entity();
        dxcriteria1Entity.setDxc1Name(dxc1name);
        return this.dxcriteria1DAO.getDxcriteria1(dxcriteria1Entity).get(0);
    }
}
