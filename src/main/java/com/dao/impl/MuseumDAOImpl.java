package com.dao.impl;

import com.dao.BaseHibernateDAO;
import com.dao.MuseumDAO;
import com.entity.MuseumEntity;
import db.MyHibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by X on 2018/1/1.
 */
public class MuseumDAOImpl extends BaseHibernateDAO implements MuseumDAO{

    @Override
    public void addMuseum(MuseumEntity museumEntity) {
        /**
        *@Description:添加博物馆
        *@Author:xyj
        *@Date:15:51 2018/1/1
        **/
        super.add(museumEntity);
    }

    @Override
    public void deleteMuseum(MuseumEntity museumEntity) {
        /**
        *@Description:删除博物馆
        *@Author:xyj
        *@Date:15:53 2018/1/1
        **/
        super.delete(museumEntity);
    }

    @Override
    public void updateMuseum(MuseumEntity museumEntity) {
        /**
        *@Description:修改博物馆
        *@Author:xyj
        *@Date:15:55 2018/1/1
        **/
        super.update(museumEntity);
    }

    @Override
    public List<MuseumEntity> getMuseum(MuseumEntity museumEntity) {
        /**
        *@Description:根据选择的属性，筛选出符合条件的博物馆
        *@Author:xyj
        *@Date:15:56 2018/1/1
        **/
        String sql;

        Transaction tx=null;
        List<MuseumEntity> museumEntities = new ArrayList<>();
        try{
            sql="select *  from museum where 1=1";

            if(museumEntity.getMid()>0){
                sql=sql+" and mid= "+museumEntity.getMid();
            }
            if(museumEntity.getMname()!=null && museumEntity.getMname()!=""){
                sql=sql+" and mname='"+museumEntity.getMname()+"'";
            }
            if(museumEntity.getMtype()!=null && museumEntity.getMtype()!=""){
                sql=sql+" and mtype='"+museumEntity.getMtype()+"'";
            }
            if(museumEntity.getMclass()!=null && museumEntity.getMclass()!=""){
                sql=sql+" and mclass='"+museumEntity.getMclass()+"'";
            }
            if(museumEntity.getDescription()!=null && museumEntity.getDescription()!=""){
                sql=sql+" and description='"+museumEntity.getDescription()+"'";
            }

            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            System.out.println("hello");
            museumEntities = session.createSQLQuery(sql).addEntity(MuseumEntity.class).list();
            tx.commit();
            System.out.println("SQL execute success");
            System.out.println("size = " + museumEntities.size());
            if (museumEntities.size()>0)
                System.out.print("dao层成功");
            else
                System.out.print("失败");
        }catch (Exception e) {
            e.printStackTrace();
            tx.commit();
            System.out.println("SQL execute fail");
        } finally {
            if (tx != null) {
                tx = null;
            }
        }

        return museumEntities;
    }
}
