package com.dao;

import db.MyHibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

/**
 * @Author: zzh
 * @Description:
 * @Date: Created in 23:12 2017/4/7
 * @Modified By:
 */
public class BaseHibernateDAO {
    //添加数据
    protected boolean add(Object object){
        //获得Session实例
        Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        boolean succeed=true;
        try{
            //开始一个事务
            tx = session.beginTransaction();
            //调用save方法持久化object对象，之后object对象转变为持久状态
            session.save(object);
            //提交事务，向数据库中插入一个新纪录
            tx.commit();
        }catch (Exception e){
            if(tx!=null){
                tx.rollback();  //事务回滚
            }
            e.printStackTrace();
            succeed = false;
        }finally {
            MyHibernateSessionFactory.closeSession();   //关闭session
            //此时object对象处于托管态

            return  succeed;
        }
    }

    //删除数据
    protected boolean delete(Object object){
        //获得session实例
        Session session = MyHibernateSessionFactory.getSession();
        Transaction tx = null;
        boolean succeed = true;
        try
        {
            tx = session.beginTransaction();    //开始一个事务
            session.delete(object);               //执行删除
            tx.commit();                        //提交事务
        }catch (Exception e)
        {
            if(tx!=null){
                tx.rollback();         //事务回滚
            }
            e.printStackTrace();
            succeed = false;
        } finally {
            MyHibernateSessionFactory.closeSession();  //关闭Session
            return succeed;
        }
    }

    //修改数据
    protected boolean update(Object object){
        Session session = MyHibernateSessionFactory.getSession();
        Transaction tx = null;
        boolean succeed = true;
        try {
            tx = session.beginTransaction();
            session.update(object);
            tx.commit();
        }catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            succeed = false;
        } finally {
            MyHibernateSessionFactory.closeSession();
            return succeed;
        }
    }

    //加载数据
    protected Object get(Class cla, Serializable id){
        Object object = null;
//        Session session = MyHibernateSessionFactory.getSession();
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            object = session.get(cla,id);
            if(object==null){
                System.out.println("qqqqqqqqqqqqqqqqqqqq");
            }
            transaction.commit();
            session.close();
            sessionFactory.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyHibernateSessionFactory.closeSession();
        }
        return object;
    }
}
