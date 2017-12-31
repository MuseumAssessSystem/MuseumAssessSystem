package com.dao.impl;

import com.dao.UserDAO;
import com.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10922 on 2017/12/29.
 */
/*
 * 接口实现的快捷方式 ALT + INSERT
 */
@Transactional(rollbackFor = Exception.class)
//出现Exception异常回滚
@Repository("userDao") //进行注入
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    @Resource(name="hibernateTemplate")
    private HibernateTemplate hibernateTemplate;


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
        hibernateTemplate.saveOrUpdate(userEntity);
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
        hibernateTemplate.delete(userEntity);
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
        hibernateTemplate.update(userEntity);
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

        sql="select * from user where 1=1";

        if(userEntity.getUid()>0){      //
            sql=sql+" and uid='"+userEntity.getUid()+"'";
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

        List<UserEntity> users  = (List<UserEntity>) hibernateTemplate.find(sql);
        return users;
    }

}
