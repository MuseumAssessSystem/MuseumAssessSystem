package com.dao.impl;

import com.dao.UserDAO;
import com.entity.UserEntity;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by 10922 on 2017/12/29.
 */
/*
 * 接口实现的快捷方式 ALT + INSERT
 */
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
    private HibernateTemplate ht;
    @Override
    public boolean addUser(UserEntity userEntity) {

        return false;
    }

    @Override
    public boolean deleteUser(UserEntity userEntity) {
        return false;
    }

    @Override
    public boolean modifyUser(UserEntity userEntity) {
        return false;
    }

    /*** HibernateTemplate使用实例 **/
    /**
    public UserEntity getUserById(int id){
        return (UserEntity)this.ht.get(UserEntity.class,id);
    }
     **/
}
