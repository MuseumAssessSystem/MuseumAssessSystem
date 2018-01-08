package com.service.impl;

import com.dao.DxassessexpertDAO;
import com.dao.impl.DxassessexpertDAOImpl;
import com.entity.DxassessexpertEntity;
import com.entity.ExpertEntity;
import com.service.DxassessexpertService;

import java.util.List;

/**
 * Created by admin on 2018/1/6.
 */
public class DxassessexpertServiceImpl implements DxassessexpertService {
    private DxassessexpertDAO dxassessexpertDAO = new DxassessexpertDAOImpl();
    @Override
    public boolean addDxassessexpert(DxassessexpertEntity dxassessexpertEntity) {
        this.dxassessexpertDAO.addDxassessexpert(dxassessexpertEntity);
        return true;
    }

    @Override
    public boolean updateDxassessexpert(DxassessexpertEntity dxassessexpertEntity) {
        this.dxassessexpertDAO.updateDxassessexpert(dxassessexpertEntity);
        return true;
    }

    @Override
    public boolean deleteDxassessexpert(DxassessexpertEntity dxassessexpertEntity) {
        this.dxassessexpertDAO.deleteDxassessexpert(dxassessexpertEntity);
        return true;
    }

    @Override
    public List<DxassessexpertEntity> getDxassessexpert(DxassessexpertEntity dxassessexpertEntity) {
        return this.dxassessexpertDAO.getDxassessexpert(dxassessexpertEntity);
    }

    @Override
    public List<DxassessexpertEntity> getAllDxassessexpert() {
        DxassessexpertEntity dxassessexpertEntity = new DxassessexpertEntity();
        return this.dxassessexpertDAO.getDxassessexpert(dxassessexpertEntity);
    }

    @Override
    public List<DxassessexpertEntity> getDxassessexpertByEdid(int edid) {
        DxassessexpertEntity dxassessexpertEntity = new DxassessexpertEntity();
        dxassessexpertEntity.setEdid(edid);
        return this.dxassessexpertDAO.getDxassessexpert(dxassessexpertEntity);
    }

    @Override
    public List<DxassessexpertEntity> getDxassessexpertByYear(int year) {
        DxassessexpertEntity dxassessexpertEntity = new DxassessexpertEntity();
        dxassessexpertEntity.setYear(year);
        return this.dxassessexpertDAO.getDxassessexpert(dxassessexpertEntity);
    }

    @Override
    public List<ExpertEntity> getOptionDxassessexpertByYear(int year) {
        return this.dxassessexpertDAO.getOptionDxassessexpertByYear(year);
    }
}
