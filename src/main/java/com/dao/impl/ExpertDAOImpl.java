package com.dao.impl;

import com.dao.ExpertDAO;
import com.entity.ExpertEntity;
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
@Transactional(rollbackFor = Exception.class)
//出现Exception异常回滚
@Repository("expertDao") //进行注入
public class ExpertDAOImpl extends HibernateDaoSupport implements ExpertDAO{
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    @Resource(name="hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Override
    public void addExpert(ExpertEntity expertEntity) {
        /**
         * @author:zzy
         * @Description:添加专家
         * @date 2018/1/1
         */
        hibernateTemplate.saveOrUpdate(expertEntity);

    }

    @Override
    public void deleteExpert(ExpertEntity expertEntity) {
        /**
         * @author:zzy
         * @Description:删除专家
         * @date 2018/1/1
         */
        hibernateTemplate.delete(expertEntity);

    }

    @Override
    public void updateExpert(ExpertEntity expertEntity) {
        /**
         * @author:zzy
         * @Description:修改专家信息
         * @date 2018/1/1
         */
        hibernateTemplate.update(expertEntity);

    }

    @Override
    public List<ExpertEntity> getExpert(ExpertEntity expertEntity) {
        /**
         * @author:zzy
         * @Description:根据属性，获得符合条件的专家
         * @date 2018/1/1
         */
        String sql;

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

        List<ExpertEntity> experts  = (List<ExpertEntity>) hibernateTemplate.find(sql);
        return experts;
    }
}

