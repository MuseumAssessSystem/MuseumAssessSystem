package com.service.impl;

import com.dao.ExpertDAO;
import com.dao.impl.ExpertDAOImpl;
import com.entity.ExpertEntity;
import com.service.ExpertService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by admin on 2018/1/3.
 */
@Transactional
public class ExpertServiceImpl implements ExpertService {
    private ExpertDAO expertDAO = new ExpertDAOImpl();

    @Override
    public boolean addExpert(ExpertEntity expertEntity) {
        this.expertDAO.addExpert(expertEntity);
        return true;
    }

    @Override
    public List getAllExpert() {
        ExpertEntity expertEntity = new ExpertEntity();
        return this.expertDAO.getExpert(expertEntity);
    }

    @Override
    public ExpertEntity getExpertByEname(String ename) {
        ExpertEntity expertEntity = new ExpertEntity();
        expertEntity.setEname(ename);
        return this.expertDAO.getExpert(expertEntity).get(0);
    }

    @Override
    public ExpertEntity getExpertByEid(int eid) {
        ExpertEntity expertEntity = new ExpertEntity();
        expertEntity.setEid(eid);
        return this.expertDAO.getExpert(expertEntity).get(0);
    }

    @Override
    public boolean updateExpert(ExpertEntity expertEntity) {
        this.expertDAO.updateExpert(expertEntity);
        return true;
    }

    @Override
    public boolean deleteExpert(int eid) {
        this.expertDAO.deleteExpert(new ExpertEntity(eid));
        return true;
    }
}
