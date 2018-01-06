package com.dao.impl;

import com.dao.BaseHibernateDAO;
import com.dao.DxassessexpertDAO;
import com.entity.DxassessexpertEntity;
import db.MyHibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/1/6.
 */
public class DxassessexpertDAOImpl extends BaseHibernateDAO implements DxassessexpertDAO {
    @Override
    public void addDxassessexpert(DxassessexpertEntity dxassessexpertEntity) {
        super.add(dxassessexpertEntity);
    }

    @Override
    public void updateDxassessexpert(DxassessexpertEntity dxassessexpertEntity) {
        super.update(dxassessexpertEntity);

    }

    @Override
    public void deleteDxassessexpert(DxassessexpertEntity dxassessexpertEntity) {
        super.update(dxassessexpertEntity);

    }

    @Override
    public List<DxassessexpertEntity> getDxassessexpert(DxassessexpertEntity dxassessexpertEntity) {
        String sql;
        Transaction tx = null;
        List<DxassessexpertEntity> dxassessexpertEntities = new ArrayList<>();
        try{
            sql="select * from dxassessexpert where 1=1";

            if(dxassessexpertEntity.getEdid()!=0){
                sql=sql+" and edid="+ dxassessexpertEntity.getEdid()+"";
            }
            if(dxassessexpertEntity.getYear()!=0)
            {
                sql = sql+" and year='"+ dxassessexpertEntity.getYear()+"'";
            }

           if(dxassessexpertEntity.getEid()!=0)
           {
               sql = sql +" and eid="+dxassessexpertEntity.getEid()+"";
           }
           if(dxassessexpertEntity.getDxc1id()!=0)
           {
               sql =sql+" and dxc1id="+dxassessexpertEntity.getDxc1id()+"";
           }
           if (dxassessexpertEntity.getFlag()==0)
           {
               sql = sql+" and flag='"+dxassessexpertEntity.getFlag()+"'";
           }
           if(dxassessexpertEntity.getFlag()==1)
           {
               sql =sql+" and flag='"+dxassessexpertEntity.getFlag()+"'";
           }

            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            dxassessexpertEntities = session.createSQLQuery(sql).addEntity(DxassessexpertEntity.class).list();
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
            tx.commit();
        } finally {
            if (tx != null) {
                tx = null;
            }
        }


        return dxassessexpertEntities;
    }
}
