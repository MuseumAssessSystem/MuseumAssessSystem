package com.service.impl;

import com.dao.MuseumDAO;
import com.dao.impl.MuseumDAOImpl;
import com.entity.MuseumEntity;
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
        this.museumDAO.deleteMuseum(new MuseumEntity(mid));
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
