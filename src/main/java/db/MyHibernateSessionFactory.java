package db;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/**
 * Created by Martin on 2017/4/7.
 */
public class MyHibernateSessionFactory {
    //指定 hibernate 配置文件路径
    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    //创建 ThreadLocal 对象
    private static final ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();
    //创建 Configuration 对象
    private static Configuration configuration = new Configuration();
    //定义 SessionFactory 对象
    private static SessionFactory sessionFactory;
    //定义 configFile 属性并赋值
    private static String configFile = CONFIG_FILE_LOCATION;
    static {
        try {
            //读取配置文件 hibernate.cfg.xml
            configuration.configure();
            //生成一个注册机对象
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            //使用注册机对象 serviceRegistry 创建 sessionFactory
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    //创建无参的 HibernateSessionFactory 构造方法
    private MyHibernateSessionFactory() {}

    //获得 SessionFactory 对象
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    //重建 SessionFactory
    public static void rebuildSessionFactory(){
        synchronized (sessionFactory){
            try {
                configuration.configure(configFile);
                ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
                //使用注册机对象 serviceRegistry 创建 sessionFactory
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            catch (HibernateException e){
                e.printStackTrace();
            }
        }
    }
    //获得 Session 对象
    public static Session getSession(){
        //获得 ThreadLocal 对象管理的 Session 对象
        Session session = sessionThreadLocal.get();
        try{
            //判断 Session 对象是否已经存在或者是否打开
            if(session == null || !session.isOpen()){
                //如果为空或未打开，再判断 sessionFactory 对象是否为空
                if(sessionFactory==null){
                    //如果 sessionFactory 为空，则创建 SessionFactory
                    rebuildSessionFactory();
                }
                //如果 sessionFactory 不为空，则打开 Session
                session = (sessionFactory != null)?sessionFactory.openSession():null;
                sessionThreadLocal.set(session);
            }
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        return session;
    }
    //关闭 Session 对象
    public static void closeSession(){
        Session session = sessionThreadLocal.get();
        sessionThreadLocal.set(null);
        try{
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }
    //configFile 属性的 set 方法
    public static void setConfigFile(String configFile){
        MyHibernateSessionFactory.configFile = configFile;
        sessionFactory = null;
    }
    //configuration 属性的 get 方法
    public static Configuration getConfiguration(){
        return configuration;
    }
}
