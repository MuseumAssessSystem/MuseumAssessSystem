package com.dao.impl;

import com.dao.BaseHibernateDAO;
import com.dao.Dxcriteria1DAO;
import com.entity.Dxcriteria1Entity;
import db.MyHibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/1/1.
 */
public class Dxcriteria1DAOImpl extends BaseHibernateDAO implements Dxcriteria1DAO {

    @Override
    public List<Dxcriteria1Entity> getDxcriteria1(Dxcriteria1Entity dxcriteria1Entityy) {
        /**
         * @author:zzy
         * @Description:获取一级指标信息
         * @date 2018/1/1
         */

        String sql;
        Transaction tx=null;
        List<Dxcriteria1Entity> dxcriteria1Entities = new ArrayList<>();
        try{
            sql="select * from dxcriteria1 where 1=1";

            if(dxcriteria1Entityy.getDxc1Id()>0){
                sql=sql+" and dxc1id='"+dxcriteria1Entityy.getDxc1Id()+"'";
            }
            if(dxcriteria1Entityy.getDxc1Name()!=null && dxcriteria1Entityy.getDxc1Name()!=""){
                sql = sql + " and dxc1name = '" + dxcriteria1Entityy.getDxc1Name()+"'";
            }

            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            dxcriteria1Entities = session.createSQLQuery(sql).addEntity(Dxcriteria1Entity.class).list();
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            tx.commit();
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
        return dxcriteria1Entities;
    }
}
