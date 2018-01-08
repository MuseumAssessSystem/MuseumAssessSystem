package com.dao.impl;

import com.dao.PriviledgeDAO;
import com.entity.PriviledgeEntity;
import db.MyHibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10922 on 2018/1/8.
 */
public class PriviledgeDAOImpl implements PriviledgeDAO{
    @Override
    public List<PriviledgeEntity> getPriviledge(PriviledgeEntity priviledgeEntity) {
        String sql;
        Transaction tx=null;
        List<PriviledgeEntity> priviledges = new ArrayList<>();
        try{
            sql="select * from priviledge where 1=1";

            if(priviledgeEntity.getPid()>0){
                sql=sql+" and pid="+priviledgeEntity.getPid();
            }
            if(priviledgeEntity.getPname()!=null && priviledgeEntity.getPname()!=""){
                sql = sql + " and pname = '" + priviledgeEntity.getPname()+"'";
            }

            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            priviledges = session.createSQLQuery(sql).addEntity(PriviledgeEntity.class).list();
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
        return priviledges;
    }
}
