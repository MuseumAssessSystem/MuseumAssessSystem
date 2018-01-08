package com.service.impl;

import com.dao.DxassessDAO;
import com.dao.impl.DxassessDAOImpl;
import com.entity.DxassessEntity;
import com.service.DxassessService;

import java.util.List;

/**
 * Created by admin on 2018/1/3.
 */
public class DxassessServiceImpl implements DxassessService {
    private DxassessDAO dxassessDAO = new DxassessDAOImpl();
    @Override
    public boolean addDxassess(DxassessEntity dxassessEntity) {
        this.dxassessDAO.addDxassess(dxassessEntity);
        return true;
    }

    @Override
    public boolean updateDxassess(DxassessEntity dxassessEntity) {
        this.dxassessDAO.updateDxassess(dxassessEntity);
        return true;
    }

    @Override
    public boolean deleteDxassess(DxassessEntity dxassessEntity) {
        this.dxassessDAO.deleteDxassess(dxassessEntity);
        return true;
    }

    @Override
    public List<DxassessEntity> getDxassessByYear(int year) {
        DxassessEntity dxassessEntity =new DxassessEntity();
        dxassessEntity.setYear(year);
        return this.dxassessDAO.getDxassess(dxassessEntity);
    }

    @Override
    public List<DxassessEntity> getDxassessByMid(int mid) {
        DxassessEntity dxassessEntity = new DxassessEntity();
        dxassessEntity.setMid(mid);
        return this.dxassessDAO.getDxassess(dxassessEntity);
    }
}
