package com.dao.impl;

import com.dao.BaseHibernateDAO;
import com.dao.UserDAO;
import com.entity.UserEntity;
import db.MyHibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10922 on 2017/12/29.
 */
/*
 * 接口实现的快捷方式 ALT + INSERT
 */
public class UserDAOImpl extends BaseHibernateDAO implements UserDAO {

    //private HibernateTemplate hibernateTemplate;

    @Override
    public void addUser(UserEntity userEntity) {
        /**
         *@描述 添加用户
         *@参数 [userEntity]
         *@返回值 void
         *@创建人 zzh
         *@创建时间 2017/12/31
         *@修改人和其它时间
        **/
        super.add(userEntity);
    }

    @Override
    public void deleteUser(UserEntity userEntity) {
        /**
         *@描述 删除用户
         *@参数 [userEntity]
         *@返回值 void
         *@创建人 zzh
         *@创建时间 2017/12/31
         *@修改人和其它时间
        **/
        super.delete(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        /**
         *@描述 修改用户
         *@参数 [userEntity]
         *@返回值 void
         *@创建人 zzh
         *@创建时间 2017/12/31
         *@修改人和其它时间
        **/
        super.update(userEntity);
    }

    @Override
    public List<UserEntity> getUser(UserEntity userEntity) {
        /**
         *@描述 根据属性，获得符合条件的用户
         *@参数 [userEntity]
         *@返回值 java.util.List<com.entity.UserEntity>
         *@创建人 zzh
         *@创建时间 2017/12/31
         *@修改人和其它时间
        **/
        String sql;
        Transaction tx=null;
        List<UserEntity> users = new ArrayList<>();
        try{
            sql="select * from user where 1=1";

            if(userEntity.getUid()>0){      //
                sql=sql+" and uid="+userEntity.getUid();
            }
            if(userEntity.getUname()!=null && userEntity.getUname()!=""){
                sql = sql + " and uname = '" + userEntity.getUname()+"'";
            }
            if(userEntity.getPassword()!=null && userEntity.getPassword()!=""){
                sql=sql+" and password='"+userEntity.getPassword()+"'";
            }
            if(userEntity.getRid()>0){
                sql=sql+" and utype='"+userEntity.getRid()+"'";
            }

            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            users = session.createSQLQuery(sql).addEntity(UserEntity.class).list();
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
        return users;
    }
}
