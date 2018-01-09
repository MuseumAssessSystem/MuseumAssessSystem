package com.service.impl;

import com.dao.DlassessDAO;
import com.dao.DxassessDAO;
import com.dao.DxassessexpertDAO;
import com.dao.MuseumDAO;
import com.dao.impl.DlassessDAOImpl;
import com.dao.impl.DxassessDAOImpl;
import com.dao.impl.DxassessexpertDAOImpl;
import com.dao.impl.MuseumDAOImpl;
import com.entity.DlassessEntity;
import com.entity.DxassessEntity;
import com.entity.DxassessexpertEntity;
import com.entity.MuseumEntity;
import com.service.DlassessService;
import com.service.MuseumService;

import java.util.List;

/**
 * Created by X on 2018/1/3.
 */
public class MuseumServiceImpl implements MuseumService {
    
    private MuseumDAO museumDAO =new MuseumDAOImpl();

    @Override
    public boolean addMuseum(MuseumEntity museumEntity){
        /**
        *@Description:添加博物馆
        *@Author:xyj
        *@Date:22:18 2018/1/3
        **/
        this.museumDAO.addMuseum(museumEntity);
        return true;
    }

    @Override
    public boolean deleteMuseum(int mid) {
        /**
        *@Description:根据mid值，删除指定博物馆
        *@Author:xyj
        *@Date:22:19 2018/1/3
        **/
        DxassessexpertDAO dxassessexpertDAO = new DxassessexpertDAOImpl();
        DlassessDAO dlDAO = new DlassessDAOImpl();
        DxassessDAO dxDAO = new DxassessDAOImpl();
        DxassessexpertDAO deDAO = new DxassessexpertDAOImpl();

        // 删除dxassessexpert表中mid对应的记录
        DxassessexpertEntity deEntity = new DxassessexpertEntity();
        deEntity.setMid(mid);
        List<DxassessexpertEntity> deEntities = dxassessexpertDAO.getDxassessexpert(deEntity);
        for(int i=0;i<deEntities.size();i++){
            deDAO.deleteDxassessexpert(deEntities.get(i));
        }

        // 删除dxassess表中mid对应的记录
        DxassessEntity dxEntity = new DxassessEntity();
        dxEntity.setMid(mid);
        List<DxassessEntity> dxEntities = dxDAO.getDxassess(dxEntity);
        for(int i=0;i<dxEntities.size();i++){
            dxDAO.deleteDxassess(dxEntities.get(i));
        }

        // 删除dlassess表中mid对应的记录
        DlassessEntity dlEntity = new DlassessEntity();
        dlEntity.setMid(mid);
        List<DlassessEntity> dlEntities = dlDAO.getDlassess(dlEntity);
        for(int i=0;i<dlEntities.size();i++){
            dlDAO.deleteDlassess(dlEntities.get(i));
        }

        // 删除博物馆
        this.museumDAO.deleteMuseum(new MuseumEntity(mid));

        // 更新
        DlassessService dlService = new DlassessServiceImpl();
        for (int i=0;i<dlEntities.size();i++){
            dlService.computeDlassess(dlEntities.get(i).getYear());
        }
        return true;
    }

    @Override
    public boolean updateMuseum(MuseumEntity museumEntity) {
        /**
        *@Description:修改博物馆
        *@Author:xyj
        *@Date:22:27 2018/1/3
        **/
        this.museumDAO.updateMuseum(museumEntity);
        return true;
    }

    @Override
    public List<MuseumEntity> getAllMuseum() {
        /**
        *@Description:获得所有博物馆的信息
        *@Author:xyj
        *@Date:22:30 2018/1/3
        **/
        MuseumEntity museumEntity =new MuseumEntity();
        return this.museumDAO.getMuseum(museumEntity);
    }

    @Override
    public List<MuseumEntity> getMuseumByName(String mname) {
        /**
        *@Description:根据博物馆名称进行搜索
        *@Author:xyj
        *@Date:22:41 2018/1/3
        **/
        MuseumEntity museumEntity =new MuseumEntity();
        museumEntity.setMname(mname);
        return this.museumDAO.getMuseum(museumEntity);
    }

    @Override
    public List<MuseumEntity> getMuseumById(int mid) {
        /**
        *@Description:根据mid的值，查看指定博物馆信息
        *@Author:xyj
        *@Date:22:41 2018/1/3
        **/
        return this.museumDAO.getMuseum(new MuseumEntity(mid));
    }

    @Override
    public List<MuseumEntity> getMuseumByMtype(String mtype){
        MuseumEntity museumEntity=new MuseumEntity();
        museumEntity.setMtype(mtype);
        return this.museumDAO.getMuseum(museumEntity);
    }

    @Override
    public List<MuseumEntity> getMuseumByMclass(String mclass){
        MuseumEntity museumEntity=new MuseumEntity();
        museumEntity.setMclass(mclass);
        return this.museumDAO.getMuseum(museumEntity);
    }

}
