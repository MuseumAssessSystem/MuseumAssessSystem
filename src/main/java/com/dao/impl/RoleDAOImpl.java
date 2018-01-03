package com.dao.impl;

import com.dao.BaseHibernateDAO;
import com.dao.RoleDAO;
import com.entity.RoleEntity;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10922 on 2018/1/2.
 */
public class RoleDAOImpl extends BaseHibernateDAO implements RoleDAO{


    @Override
    public void addRole(RoleEntity roleEntity) {
        super.add(roleEntity);
    }

    @Override
    public void deleteRole(RoleEntity roleEntity) {
        super.delete(roleEntity);
    }

    @Override
    public void updateRole(RoleEntity roleEntity) {
        super.update(roleEntity);
    }

    @Override
    public List getRole(RoleEntity roleEntity) {
        String sql;
        Transaction tx = null;
        List<RoleEntity> roleEntities = new ArrayList<>();
        try{
            sql="select * from role where 1=1";

            if(roleEntity.getRid()!=0){
                sql=sql+" and rid='"+ roleEntity.getRid()+"'";
            }

            if(roleEntity.getRname()!=null && roleEntity.getRname()!=""){
                sql = sql + " and rname = '" + roleEntity.getRname()+"'";
            }

        }catch (Exception e){
            e.printStackTrace();
            tx.commit();
        } finally {
            if (tx != null) {
                tx = null;
            }
        }


        return null;
    }
}
