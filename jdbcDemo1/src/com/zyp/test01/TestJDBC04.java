package com.zyp.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/21 - 11 - 21 - 16:12
 * @Description: com.zyp
 * @version: 1.0
 */
public class TestJDBC04 {
    private static String driver ="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/datawei?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String user="root";
    private static String password="root1234";
    public static void main(String[] args)   {
        Connection connection =null;
        Statement statement =null;
        try{
            connection =DriverManager.getConnection(url, user,password );
             statement = connection.createStatement();
            String sql="insert into dept values( 88 ,'助教部门','北京');";
            int rows = statement.executeUpdate(sql);
            System.out.println("影响数据行数为:"+rows);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != connection){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           if(null != connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
           }
        }
    }
}
