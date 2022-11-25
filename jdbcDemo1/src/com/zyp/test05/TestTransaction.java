package com.zyp.test05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/22 - 11 - 22 - 14:13
 * @Description: com.zyp.test05
 * @version: 1.0
 */
public class TestTransaction {
    private static String driver ="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/datawei?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useServerPrepStmts=true&cachePrepStmts=true&rewriteBatchedStatements=true";
    private static String user="root";
    private static String password="root1234";
    //这是一个main方法，是程序的入口:
    public static void main(String[] args) {
        TestTransaction();
    }
    public static void TestTransaction(){
        // 向 Emp表中增加一条数据
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        try{
            connection = DriverManager.getConnection(url, user,password );
            // 设置事务手动提交
            connection.setAutoCommit(false);
            String sql="update account set money =money- ? where aid = ?";
            preparedStatement = connection.prepareStatement(sql);//这里已经传入SQL语句
            System.out.println(sql+"---sql");
            // 转出
            preparedStatement.setDouble(1, 100);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
            // 产生异常
           //int i =1/0;
            // 转入
            preparedStatement.setDouble(1, -100);
            preparedStatement.setInt(2, 2);
            preparedStatement.executeUpdate();
            System.out.println(preparedStatement+"---preparedStatement");
        }catch (Exception e){
            if(null != connection){
                try {
                    connection.rollback();// 回滚事务
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            // 提交事务
            if(null != connection){
                try {
                    connection.commit();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != preparedStatement){
                try {
                    preparedStatement.close();
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
