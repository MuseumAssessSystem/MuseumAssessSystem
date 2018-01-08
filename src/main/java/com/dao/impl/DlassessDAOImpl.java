package com.dao.impl;

import com.dao.BaseHibernateDAO;
import com.dao.DlassessDAO;
import com.entity.DlassessEntity;
import db.MyHibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by X on 2018/1/1.
 */
public class DlassessDAOImpl extends BaseHibernateDAO implements DlassessDAO{

    @Override
    public void addDlassess(DlassessEntity dlassessEntity) {
        /**
        *@Description:添加定量分数表
        *@Author:xyj
        *@Date:17:48 2018/1/1
        **/
        super.add(dlassessEntity);
    }

    @Override
    public void deleteDlassess(DlassessEntity dlassessEntity) {
        /**
        *@Description:删除定量分数表
        *@Author:xyj
        *@Date:17:50 2018/1/1
        **/
        super.delete(dlassessEntity);
    }

    @Override
    public void updateDlassess(DlassessEntity dlassessEntity) {
        /**
        *@Description:修改定量分数表
        *@Author:xyj
        *@Date:17:51 2018/1/1
        **/
        super.update(dlassessEntity);
    }

    @Override
    public List<DlassessEntity> getDlassess(DlassessEntity dlassessEntity) {
        /**
        *@Description:查询定量分数表
        *@Author:xyj
        *@Date:17:52 2018/1/1
        **/

        String sql;
        Transaction tx=null;
        List<DlassessEntity> dlassessEntities = new ArrayList<>();
        try{
            sql="select * from dlassess where 1=1";

            if(dlassessEntity.getDlaid()>0){
                sql=sql+" and dlaid="+dlassessEntity.getDlaid();
            }
            if(dlassessEntity.getMid()>0){
                sql=sql+" and mid="+dlassessEntity.getMid();
            }
            if(dlassessEntity.getYear()>0){
                sql=sql+" and year="+dlassessEntity.getYear();
            }

            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.createSQLQuery(sql);
            dlassessEntities = session.createSQLQuery(sql).addEntity(DlassessEntity.class).list();
            System.out.println("size = " + dlassessEntities.size());
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            tx.commit();
            System.out.println("SQL error");
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
        return dlassessEntities;
    }
}
