package com.zyp.test01;

import com.zyp.entity.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/21 - 11 - 21 - 16:12
 * @Description: com.zyp
 * @version: 1.0
 */
public class TestJDBC06 {
    private static String driver ="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/datawei?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String user="root";
    private static String password="root1234";
    public static void main(String[] args)   {
        List<Emp> emps = testQuery();
        // 遍历集合
        System.out.println("=======================================================");
        for (Emp emp : emps) {
            System.out.println(emp);
        }
        System.out.println("=======================================================");
    }
    public static List<Emp> testQuery(){
        Connection connection =null;
        Statement statement =null;
        ResultSet resultSet =null;
        List<Emp> list =null;
        try{
            connection =DriverManager.getConnection(url, user,password );
            statement = connection.createStatement();
            String sql="select * from emp";
              resultSet = statement.executeQuery(sql);
            boolean next = false;
            list=new ArrayList<>();
            while(resultSet.next()){
                int empno = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                String job = resultSet.getString("job");
                int mgr = resultSet.getInt("mgr");
                Date hiredate = resultSet.getDate("hiredate");
                double sal= resultSet.getDouble("sal");
                double comm= resultSet.getDouble("comm");
                int deptno= resultSet.getInt("deptno");
                System.out.println(""+empno+" "+ename+" "+job+" "+mgr+" "+hiredate+" "+sal+" "+comm+" "+deptno);
                Emp emp =new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
                list.add(emp);
            }
            System.out.println("--------------------------------------");
              next = resultSet.next();
            System.out.println("next---"+next);
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
        return list;
    }
}
