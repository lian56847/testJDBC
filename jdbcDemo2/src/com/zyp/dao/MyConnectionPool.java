package com.zyp.dao;


import com.zyp.util.PropertiesUtil;
import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/23 - 11 - 23 - 19:50
 * @Description: com.zyp.dao
 * @version: 1.0
 */
public class MyConnectionPool {
    private static String driver  ;
    private static String url  ;
    private static String user ;
    private static String password ;
    private static int initSize ;
    private static int maxSize ;
    private static Logger logger;



    private static LinkedList<Connection> pool;
    static{
        logger=Logger.getLogger(MyConnectionPool.class);

        PropertiesUtil propertiesUtil=new PropertiesUtil("/jdbc.properties");
        driver=propertiesUtil.getProperties("driver");
        url=propertiesUtil.getProperties("url");
        user=propertiesUtil.getProperties("user");
        password=propertiesUtil.getProperties("password");
        initSize=Integer.parseInt(propertiesUtil.getProperties("initSize"));
        maxSize=Integer.parseInt(propertiesUtil.getProperties("maxSize"));
        // 加载驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            logger.fatal("wei---找不到数据库驱动类"+driver,e);
        }
        // 初始化pool
        pool=new LinkedList<Connection>();
        for (int i = 0; i <initSize ; i++) {
            Connection connection = initConnection();
            if(null != connection){
               pool.add(connection);
                logger.info("wei---初始化连接"+connection.hashCode()+"放入连接池");
            }
        }
    }
    // 私有的初始化一个链接对象的方法
    private static Connection initConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            logger.fatal("wei---初始化连接异常",e);
        }
        return null;
    }
    // 共有的向外界提供链接对象的
    public static Connection getConnection(){
        Connection connection =null;
        if(pool.size()>0){
            connection= pool.removeFirst();// 移除集合中的第一个元素
            logger.info("wei---连接池中还有连接:"+connection.hashCode());
        }else{
            connection = initConnection();
            logger.info("wei---连接池空,创建新连接:"+connection.hashCode());
        }
        return connection;
    }
    // 共有的向连接池归还连接对象的方法
    public static void returnConnection(Connection connection){
        if(null != connection){
            try {
                if(!connection.isClosed()){
                    if(pool.size()<maxSize){
                        try {
                            connection.setAutoCommit(true);// 调整事务状态
                            logger.debug("wei---设置连接:"+connection.hashCode()+"自动提交为true");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        pool.addLast(connection);
                        logger.info("wei---连接池未满,归还连接:"+connection.hashCode());
                    }else{
                        try {
                            connection.close();
                            logger.info("wei---连接池满了,关闭连接:"+connection.hashCode());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }else {
                    logger.info("wei---连接:"+connection.hashCode()+"已经关闭,无需归还");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else{
            logger.warn("wei---传入的连接为null,不可归还");
        }
    }
}
