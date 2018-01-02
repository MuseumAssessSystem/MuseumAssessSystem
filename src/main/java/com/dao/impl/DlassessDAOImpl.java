package com.dao.impl;

import com.dao.DlassessDAO;
import com.entity.DlassessEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by X on 2018/1/1.
 */
@Transactional(rollbackFor = Exception.class)
@Repository("dlassessDAO")
public class DlassessDAOImpl extends HibernateDaoSupport implements DlassessDAO{
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Override
    public void addDlassess(DlassessEntity dlassessEntity) {
        /**
        *@Description:添加定量分数表
        *@Author:xyj
        *@Date:17:48 2018/1/1
        **/
        hibernateTemplate.saveOrUpdate(dlassessEntity);
    }

    @Override
    public void deleteDlassess(DlassessEntity dlassessEntity) {
        /**
        *@Description:删除定量分数表
        *@Author:xyj
        *@Date:17:50 2018/1/1
        **/
        hibernateTemplate.delete(dlassessEntity);
    }

    @Override
    public void updateDlassess(DlassessEntity dlassessEntity) {
        /**
        *@Description:修改定量分数表
        *@Author:xyj
        *@Date:17:51 2018/1/1
        **/
        hibernateTemplate.update(dlassessEntity);
    }

    @Override
    public List<DlassessEntity> getDlassess(DlassessEntity dlassessEntity) {
        /**
        *@Description:查询定量分数表
        *@Author:xyj
        *@Date:17:52 2018/1/1
        **/
        String sql;
        sql="select * from dlassess where 1=1";

        if(dlassessEntity.getDlaid()>0){
            sql=sql+"and dlaid="+dlassessEntity.getDlaid();
        }
        if(dlassessEntity.getMid()>0){
            sql=sql+"and mid="+dlassessEntity.getMid();
        }
        if(dlassessEntity.getYear()>0){
            sql=sql+"and year="+dlassessEntity.getYear();
        }
        List<DlassessEntity> dlassessEntities =(List<DlassessEntity>) hibernateTemplate.find(sql);
        return dlassessEntities;
    }
}
