package com.service.impl;

import com.dao.DlassessDAO;
import com.dao.impl.DlassessDAOImpl;
import com.entity.DlassessEntity;
import com.service.DlassessService;

import java.util.List;

/**
 * Created by X on 2018/1/5.
 */
public class DlassessServiceImpl implements DlassessService {
    private  DlassessDAO dlassessDAO =new DlassessDAOImpl();

    @Override
    public List<DlassessEntity> getDlassessByMid(int mid){
        /**
        *@Description:通过mid获取定量分数表
        *@Author:xyj
        *@Date:22:33 2018/1/6
        **/
        DlassessEntity dlassessEntity=new DlassessEntity();
        dlassessEntity.setMid(mid);
        return this.dlassessDAO.getDlassess(dlassessEntity);
    }
    @Override
    public List<DlassessEntity> getDlassess()
    {
        /**
        *@Description:获取定量分数表
        *@Author:xyj
        *@Date:22:34 2018/1/6
        **/
        DlassessEntity dlassessEntity=new DlassessEntity();
         return this.dlassessDAO.getDlassess(dlassessEntity);
    }
    @Override
    public List<DlassessEntity> getDlassessByYear(int year){
        DlassessEntity dlassessEntity =new DlassessEntity();
        dlassessEntity.setYear(year);
        return this.dlassessDAO.getDlassess(dlassessEntity);
    }
    @Override
    public boolean addDlassess(DlassessEntity dlassessEntity){
        this.dlassessDAO.addDlassess(dlassessEntity);
        return true;
    }
    @Override
    public boolean deleteDlassess(DlassessEntity dlassessEntity){
        this.dlassessDAO.deleteDlassess(dlassessEntity);
        return true;
    }
    @Override
    public boolean updateDlassess(DlassessEntity dlassessEntity){
        this.dlassessDAO.updateDlassess(dlassessEntity);
        return true;
    }

}
