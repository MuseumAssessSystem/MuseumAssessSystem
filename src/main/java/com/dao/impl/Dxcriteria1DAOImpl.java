package com.dao.impl;

import com.dao.Dxcriteria1DAO;
import com.entity.Dxcriteria1Entity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2018/1/1.
 */
@Transactional(rollbackFor = Exception.class)
//出现Exception异常回滚
@Repository("dxcriteria1Dao") //进行注入
public class Dxcriteria1DAOImpl extends HibernateDaoSupport implements Dxcriteria1DAO {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    @Resource(name="hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Dxcriteria1Entity> getDxcriteria1(Dxcriteria1Entity dxcriteria1Entityy) {
        /**
         * @author:zzy
         * @Description:获取一级指标信息
         * @date 2018/1/1
         */
        String sql;

        sql="select * from dxcriteria1 where 1=1";

        if(dxcriteria1Entityy.getDxc1Id()>0){
            sql=sql+" and dxc1id='"+dxcriteria1Entityy.getDxc1Id()+"'";
        }
        if(dxcriteria1Entityy.getDxc1Name()!=null && dxcriteria1Entityy.getDxc1Name()!=""){
            sql = sql + " and dxc1name = '" + dxcriteria1Entityy.getDxc1Name()+"'";
        }
        List<Dxcriteria1Entity> result = (List<Dxcriteria1Entity>) hibernateTemplate.find(sql);
        return result;
    }
}
