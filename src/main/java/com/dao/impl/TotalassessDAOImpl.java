package com.dao.impl;

import com.dao.BaseHibernateDAO;
import com.dao.TotalassessDAO;
import com.entity.TotalassessEntity;
import db.MyHibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10922 on 2018/1/8.
 */
public class TotalassessDAOImpl extends BaseHibernateDAO implements TotalassessDAO {
    @Override
    public void addTEntity(TotalassessEntity tEntity) {
        super.add(tEntity);
    }

    @Override
    public void deleteTEntity(TotalassessEntity tEntity) {
        super.delete(tEntity);
    }

    @Override
    public void updateTEntity(TotalassessEntity tEntity) {
        super.update(tEntity);
    }

    @Override
    public List<TotalassessEntity> getTEntity(TotalassessEntity tEntity) {
        String sql;
        Transaction tx=null;
        List<TotalassessEntity> totals = new ArrayList<>();
        try{
            sql="select * from totalassess where 1=1";

            if(tEntity.getTaid()>0){      //
                sql=sql+" and taid="+tEntity.getTaid();
            }
            if(tEntity.getMid()>0){
                sql = sql + " and mid = " + tEntity.getMid();
            }
            if(tEntity.getTscore()>0){
                sql=sql+" and tsocre="+tEntity.getTscore();
            }
            if(tEntity.getYear()>0){
                sql=sql+" and year="+tEntity.getYear();
            }
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            totals = session.createSQLQuery(sql).addEntity(TotalassessEntity.class).list();
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
        return totals;
    }
}
