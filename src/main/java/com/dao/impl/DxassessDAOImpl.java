package com.dao.impl;

import com.dao.BaseHibernateDAO;
import com.dao.DxassessDAO;
import com.entity.DxassessEntity;
import db.MyHibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/1/1.
 */
public class DxassessDAOImpl extends BaseHibernateDAO implements DxassessDAO {
    @Override
    public void addDxassess(DxassessEntity dxassessEntity) {
        /**
         * @author:zzy
         * @Description:添加定性打分表
         * @date 2018/1/1
         */
        super.add(dxassessEntity);
    }

    @Override
    public void deleteDxassess(DxassessEntity dxassessEntity) {
        /**
         * @author:zzy
         * @Description:删除定性打分表
         * @date 2018/1/1
         */
        super.delete(dxassessEntity);
    }

    @Override
    public void updateDxassess(DxassessEntity dxassessEntity) {
        /**
         * @author:zzy
         * @Description:修改定性打分表
         * @date 2018/1/1
         */
        super.update(dxassessEntity);
    }

    @Override
    public List<DxassessEntity> getDxassess(DxassessEntity dxassessEntity) {
        /**
         * @author:zzy
         * @Description:获取打分信息
         * @date 2018/1/1
         */
        String sql;
        Transaction tx=null;
        List<DxassessEntity> dxassessEntities = new ArrayList<>();
        try{
            sql="select * from dxassess where 1=1";

            if(dxassessEntity.getDxaid()>0){
                sql=sql+" and dxaid='"+dxassessEntity.getDxaid()+"'";
            }
            if(dxassessEntity.getYear()>0){
                sql = sql + " and year = '" + dxassessEntity.getYear()+"'";
            }
            if(dxassessEntity.getMid()>0){
                sql = sql + " and mid ='"+dxassessEntity.getMid()+"'";
            }

            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            dxassessEntities = session.createSQLQuery(sql).addEntity(DxassessEntity.class).list();
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            tx.commit();
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
        return dxassessEntities;

    }
}
