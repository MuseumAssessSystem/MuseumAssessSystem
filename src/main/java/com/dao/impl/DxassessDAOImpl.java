package com.dao.impl;

import com.dao.DxassessDAO;
import com.entity.DxassessEntity;
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
@Repository("dxassessDao") //进行注入
public class DxassessDAOImpl extends HibernateDaoSupport implements DxassessDAO {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    @Resource(name="hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Override
    public void addDxassess(DxassessEntity dxassessEntity) {
        /**
         * @author:zzy
         * @Description:添加定性打分表
         * @date 2018/1/1
         */
        hibernateTemplate.saveOrUpdate(dxassessEntity);
    }

    @Override
    public void deleteDxassess(DxassessEntity dxassessEntity) {
        /**
         * @author:zzy
         * @Description:删除定性打分表
         * @date 2018/1/1
         */
        hibernateTemplate.delete(dxassessEntity);
    }

    @Override
    public void updateDxassess(DxassessEntity dxassessEntity) {
        /**
         * @author:zzy
         * @Description:修改定性打分表
         * @date 2018/1/1
         */
        hibernateTemplate.update(dxassessEntity);
    }

    @Override
    public List<DxassessEntity> getDxassess(DxassessEntity dxassessEntity) {
        /**
         * @author:zzy
         * @Description:获取打分信息
         * @date 2018/1/1
         */
        String sql;

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
        List<DxassessEntity> dxassesslist  = (List<DxassessEntity>) hibernateTemplate.find(sql);
        return dxassesslist;

    }
}
