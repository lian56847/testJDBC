package com.zyp.test01;

import java.sql.*;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/21 - 11 - 21 - 16:12
 * @Description: com.zyp
 * @version: 1.0
 */
public class TestJDBC03 {
    //这是一个main方法，是程序的入口:
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        String url="jdbc:mysql://127.0.0.1:3306/datawei?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String user="root";
        String password="root1234";
        Connection connection =DriverManager.getConnection(url, user,password );
        //4获得语句对象 Statment
        Statement statement = connection.createStatement();
        //5执行SQL语句,返回结果
        /*
         * insert delete update 操作都是调用statement.executeUpdate
         * executeUpdate返回一个int值,代表数据库多少行数据发生了变化
         * */
        String sql="insert into dept values( 81,'助教部门','北京');";
        int rows = statement.executeUpdate(sql);
        System.out.println("影响数据行数为:"+rows);
        //6释放资源
        /*
         * 注意顺序
         * 后获得的先关闭,先获得的后关闭
         * */
        statement.close();
        connection.close();
    }
}
