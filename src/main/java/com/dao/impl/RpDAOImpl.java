package com.dao.impl;

import com.dao.BaseHibernateDAO;
import com.dao.RpDAO;
import com.entity.RpEntity;
import db.MyHibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10922 on 2018/1/8.
 */
public class RpDAOImpl extends BaseHibernateDAO implements RpDAO{
    @Override
    public List<RpEntity> getRp(RpEntity rpEntity) {
        String sql;
        Transaction tx=null;
        List<RpEntity> rps = new ArrayList<>();
        try{
            sql="select * from rp where 1=1";

            if(rpEntity.getRpid()>0){      //
                sql=sql+" and rpid="+rpEntity.getRpid();
            }
            if(rpEntity.getRid()>0){
                sql = sql + " and rid = " + rpEntity.getRid();
            }
            if(rpEntity.getPid()>0){
                sql=sql+" and pid="+rpEntity.getPid();
            }

            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            rps = session.createSQLQuery(sql).addEntity(RpEntity.class).list();
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
        return rps;
    }
}
