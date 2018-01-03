package com.dao.impl;

import com.dao.BaseHibernateDAO;
import com.dao.ExpertDAO;
import com.entity.ExpertEntity;
import db.MyHibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10922 on 2017/12/29.
 */
public class ExpertDAOImpl extends BaseHibernateDAO implements ExpertDAO{

    @Override
    public void addExpert(ExpertEntity expertEntity) {
        /**
         * @author:zzy
         * @Description:添加专家
         * @date 2018/1/1
         */
        super.add(expertEntity);

    }

    @Override
    public void deleteExpert(ExpertEntity expertEntity) {
        /**
         * @author:zzy
         * @Description:删除专家
         * @date 2018/1/1
         */
        super.delete(expertEntity);

    }

    @Override
    public void updateExpert(ExpertEntity expertEntity) {
        /**
         * @author:zzy
         * @Description:修改专家信息
         * @date 2018/1/1
         */
        super.update(expertEntity);

    }

    @Override
    public List<ExpertEntity> getExpert(ExpertEntity expertEntity) {
        /**
         * @author:zzy
         * @Description:根据属性，获得符合条件的专家
         * @date 2018/1/1
         */
        String sql;
        Transaction tx=null;
        List<ExpertEntity> expertEntities = new ArrayList<>();
        try{
            sql="select * from expert where 1=1";

            if(expertEntity.getEid()>0){
                sql=sql+" and eid='"+expertEntity.getEid()+"'";
            }
            if(expertEntity.getEname()!=null && expertEntity.getEname()!=""){
                sql = sql + " and ename = '" + expertEntity.getEname()+"'";
            }
            if(expertEntity.getDescription()!=null && expertEntity.getDescription()!=""){
                sql=sql+" and description='"+expertEntity.getDescription()+"'";
            }
            if(expertEntity.getDxc1id()>0){
                sql=sql+" and dxc1id='"+expertEntity.getDxc1id()+"'";
            }

            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            expertEntities = session.createSQLQuery(sql).addEntity(ExpertEntity.class).list();
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            tx.commit();
        } finally {
            if (tx != null) {
                tx = null;
            }
        }



        return expertEntities;
    }
}

