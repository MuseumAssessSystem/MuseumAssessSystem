package com.dao.impl;

import com.dao.MuseumDAO;
import com.entity.MuseumEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by X on 2018/1/1.
 */
@Transactional(rollbackFor = Exception.class)

@Repository("museumDAO")
public class MuseumDAOImpl extends HibernateDaoSupport implements MuseumDAO{
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Override
    public void addMuseum(MuseumEntity museumEntity) {
        /**
        *@Description:添加博物馆
        *@Author:xyj
        *@Date:15:51 2018/1/1
        **/
        hibernateTemplate.saveOrUpdate(museumEntity);
    }

    @Override
    public void deleteMuseum(MuseumEntity museumEntity) {
        /**
        *@Description:删除博物馆
        *@Author:xyj
        *@Date:15:53 2018/1/1
        **/
        hibernateTemplate.delete(museumEntity);
    }

    @Override
    public void updateMuseum(MuseumEntity museumEntity) {
        /**
        *@Description:修改博物馆
        *@Author:xyj
        *@Date:15:55 2018/1/1
        **/
        hibernateTemplate.update(museumEntity);
    }

    @Override
    public List<MuseumEntity> getMuseum(MuseumEntity museumEntity) {
        /**
        *@Description:根据选择的属性，筛选出符合条件的博物馆
        *@Author:xyj
        *@Date:15:56 2018/1/1
        **/
        String sql;
        sql="select *  from museum where 1=1";

        if(museumEntity.getMid()>0){
            sql=sql+"and mid="+museumEntity.getMid();
        }
        if(museumEntity.getMname()!=null && museumEntity.getMname()!=""){
            sql=sql+"and mname="+museumEntity.getMname();
        }
        if(museumEntity.getMtype()!=null && museumEntity.getMtype()!=""){
            sql=sql+"and mtype="+museumEntity.getMtype();
        }
        if(museumEntity.getMclass()!=null && museumEntity.getMclass()!=""){
            sql=sql+"and mclass="+museumEntity.getMclass();
        }
        if(museumEntity.getDescription()!=null && museumEntity.getDescription()!=""){
            sql=sql+"and description="+museumEntity.getDescription();
        }
        List<MuseumEntity> museumEntities =(List<MuseumEntity>) hibernateTemplate.find(sql);
        return museumEntities;
    }
}
