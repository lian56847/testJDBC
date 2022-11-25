package com.zyp.test05;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/22 - 11 - 22 - 12:51
 * @Description: com.zyp.test04
 * @version: 1.0
 */
public class TestTransaction02 {
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
        try{
            connection = DriverManager.getConnection(url, user,password );
            String sql="insert into dept values (DEFAULT ,?,?)";
            preparedStatement = connection.prepareStatement(sql);//这里已经传入SQL语句
            System.out.println(sql+"---sql");
            int rows=0;
            //设置参数
            for (int i = 1; i <= 10000; i++) {
                preparedStatement.setString(1, "name"+i);
                preparedStatement.setString(2, "loc"+i);
                preparedStatement.addBatch();// 将修改放入一个批次中
            }
            int[] ints = preparedStatement.executeBatch();
            for (int anInt : ints) {
                System.out.println(anInt+"---anInt" );
                rows += anInt;
            }
            System.out.println(preparedStatement+"---preparedStatement");
            System.out.println(rows+"---rows");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
