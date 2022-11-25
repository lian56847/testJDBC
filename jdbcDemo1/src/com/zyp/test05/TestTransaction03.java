package com.zyp.test05;


import java.sql.*;
import java.util.LinkedList;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/22 - 11 - 22 - 12:51
 * @Description: com.zyp.test04
 * @version: 1.0
 */
public class TestTransaction03 {
    private static String driver ="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/datawei?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useServerPrepStmts=true&cachePrepStmts=true&rewriteBatchedStatements=true";
    private static String user="root";
    private static String password="root1234";
    //这是一个main方法，是程序的入口:
    public static void main(String[] args) {
        testAddBatch();
    }

    // 定义一个方法,向部门表增加1000条数据
    public static void testAddBatch(){
        // 向 Emp表中增加一条数据
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        LinkedList<Savepoint> savepoints =new LinkedList<Savepoint>();
        try{
            connection = DriverManager.getConnection(url, user,password );
            connection.setAutoCommit(false);
            String sql="insert into dept values (DEFAULT ,?,?)";
            preparedStatement = connection.prepareStatement(sql);//这里已经传入SQL语句
            System.out.println(sql+"---sql");
            //设置参数
            for (int i = 1; i <= 10060; i++) {
                preparedStatement.setString(1, "name"+i);
                preparedStatement.setString(2, "loc"+i);
                preparedStatement.addBatch();// 将修改放入一个批次中
                if(i%1000==0){
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();// 清除批处理中的数据
                    // 设置回滚点
                    Savepoint savepoint = connection.setSavepoint();
                    savepoints.addLast(savepoint);
                }
                // 数据在 100001条插入的时候出现异常
                if(i ==8001){
                    int x =1/0;
                }
            }
            preparedStatement.executeBatch();
            preparedStatement.clearBatch();// 清除批处理中的数据
            System.out.println(preparedStatement+"---preparedStatement");
        }catch (Exception e){
            if(null != connection){
                try {
                   // Savepoint sp = savepoints.getLast();
                    Savepoint sp = savepoints.get(4);
                    if(null != sp){
                        // 选择回滚点
                        connection.rollback(sp);// 回滚
                    }
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
            if(null != connection){
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
