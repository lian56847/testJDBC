package com.zyp.test1;

import com.zyp.dao.MyConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/23 - 11 - 23 - 20:19
 * @Description: com.zyp.test1
 * @version: 1.0
 */
public class Test02 {
    //这是一个main方法，是程序的入口:
    public static void main(String[] args) throws SQLException {
        Connection connection1 = MyConnectionPool.getConnection();
        Connection connection2 = MyConnectionPool.getConnection();
        Connection connection3 = MyConnectionPool.getConnection();
        Connection connection4 = MyConnectionPool.getConnection();
        Connection connection5 = MyConnectionPool.getConnection();
        Connection connection6 = MyConnectionPool.getConnection();
        Connection connection7 = MyConnectionPool.getConnection();
        Connection connection8 = MyConnectionPool.getConnection();
        Connection connection9 = MyConnectionPool.getConnection();
        Connection connection10 = MyConnectionPool.getConnection();
        Connection connection11 = MyConnectionPool.getConnection();
        Connection connection12 = MyConnectionPool.getConnection();
        Connection connection13 = MyConnectionPool.getConnection();
        Connection connection14 = MyConnectionPool.getConnection();
        Connection connection15 = MyConnectionPool.getConnection();
        Connection connection16 = MyConnectionPool.getConnection();
        Connection connection17 = MyConnectionPool.getConnection();
        System.out.println(connection1+"---connection");
       // MyConnectionPool.returnConnection(connection1);
       // MyConnectionPool.returnConnection(null);
       // connection2.close();
       // MyConnectionPool.returnConnection(connection2);
        MyConnectionPool.returnConnection(connection1);
        MyConnectionPool.returnConnection(connection2);
        MyConnectionPool.returnConnection(connection3);
        MyConnectionPool.returnConnection(connection4);
        MyConnectionPool.returnConnection(connection5);
        MyConnectionPool.returnConnection(connection6);
        MyConnectionPool.returnConnection(connection7);
        MyConnectionPool.returnConnection(connection8);
        MyConnectionPool.returnConnection(connection9);
        MyConnectionPool.returnConnection(connection10);
        MyConnectionPool.returnConnection(connection11);
        MyConnectionPool.returnConnection(connection12);
        MyConnectionPool.returnConnection(connection13);
        MyConnectionPool.returnConnection(connection14);
        MyConnectionPool.returnConnection(connection15);
        MyConnectionPool.returnConnection(connection16);
        MyConnectionPool.returnConnection(connection17);

    }
}
