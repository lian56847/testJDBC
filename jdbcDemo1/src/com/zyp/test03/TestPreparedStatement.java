package com.zyp.test03;

import com.zyp.entity.Account;
import com.zyp.entity.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/22 - 11 - 22 - 10:10
 * @Description: com.zyp.test03
 * @version: 1.0
 */
public class TestPreparedStatement {

    private static String driver ="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/datawei?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useServerPrepStmts=true&cachePrepStmts=true";
    private static String user="root";
    private static String password="root1234";

    //这是一个main方法，是程序的入口:
    public static void main(String[] args) {
        //  testAdd();
        testQuery();
        // testDelete();
        //testUpdate();
    }
    public static void testAdd(){
        // 向 Emp表中增加一条数据
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        try{
            connection = DriverManager.getConnection(url, user,password );
            String sql="insert into emp values(DEFAULT ,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);//这里已经传入SQL语句
            System.out.println(sql+"---sql");
            //设置参数
            preparedStatement.setString(1,"张飞");
            preparedStatement.setString(2,"MANAGER" );
            preparedStatement.setInt(3,7839);
            preparedStatement.setDate(4,new Date(System.currentTimeMillis()));
            preparedStatement.setDouble(5,3000.12);
            preparedStatement.setDouble(6,0.0);
            preparedStatement.setDouble(7,30);
            System.out.println(preparedStatement+"---preparedStatement");
            //执行CURD
            int rows =preparedStatement.executeUpdate();// 这里不需要再传入SQL语句
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

    public static void testUpdate(){
        // 根据工号修改员工表中的数据
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        try{
            connection = DriverManager.getConnection(url, user,password );
            String sql="update emp set ename =? ,job=? where empno =?";
            preparedStatement = connection.prepareStatement(sql);//这里已经传入SQL语句
            System.out.println(sql+"---sql");
            //设置参数
            preparedStatement.setString(1,"刘备");
            preparedStatement.setString(2,"ANALYST" );
            preparedStatement.setInt(3,7935);
            System.out.println(preparedStatement+"---preparedStatement");
            //执行CURD
            int rows =preparedStatement.executeUpdate();// 这里不需要再传入SQL语句
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

    public static void testDelete(){
        // 根据工号删除员工表中的数据
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        try{
            connection = DriverManager.getConnection(url, user,password );
            String sql="delete from emp where empno =?";
            preparedStatement = connection.prepareStatement(sql);//这里已经传入SQL语句
            System.out.println(sql+"---sql");
            //设置参数
            preparedStatement.setInt(1,7935);
            System.out.println(preparedStatement+"---preparedStatement");
            //执行CURD
            int rows =preparedStatement.executeUpdate();// 这里不需要再传入SQL语句
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
    public static void testQuery(){
        // 查询名字中包含字母A的员工信息
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet=null;

        List<Emp> list =null;
        try{
            connection = DriverManager.getConnection(url, user,password );
            String sql="select * from emp where ename like ? ";
            preparedStatement = connection.prepareStatement(sql);//这里已经传入SQL语句
            System.out.println(sql+"---sql");
            //设置参数
            preparedStatement.setString(1,"%A%");
            System.out.println(preparedStatement+"---preparedStatement");
            //执行CURD
            resultSet = preparedStatement.executeQuery();// 这里不需要再传入SQL语句
            System.out.println(resultSet+"---resultSet");
            System.out.println("-------------------------------------------");
            list=new ArrayList<Emp>() ;
            while(resultSet.next()){
                int empno = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                String job = resultSet.getString("job");
                int mgr = resultSet.getInt("mgr");
                Date hiredate = resultSet.getDate("hiredate");
                double sal= resultSet.getDouble("sal");
                double comm= resultSet.getDouble("comm");
                int deptno= resultSet.getInt("deptno");
                Emp emp =new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
                list.add(emp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != resultSet){
                try {
                    resultSet.close();
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
        // 遍历集合
        list.forEach(System.out::println);
    }
}
