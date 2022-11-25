package com.zyp.test02;

import com.zyp.entity.Account;
import com.zyp.entity.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/21 - 11 - 21 - 23:10
 * @Description: com.zyp.test02
 * @version: 1.0
 */
public class TestInjection {
    private static String driver ="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/datawei?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String user="root";
    private static String password="root1234";

    //这是一个main方法，是程序的入口:
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.next();
        System.out.println("请输入密码");
        String pwd =sc.next();
        Account account = getAccount(username, pwd);
        System.out.println(null!= account?"登录成功":"登录失败");
        sc.close();
    }
    public static Account getAccount(String username, String pwd){
        Connection connection =null;
        Statement statement =null;
        ResultSet resultSet =null;
        Account account =null;
        try{
            connection =DriverManager.getConnection(url, user,password );
            statement = connection.createStatement();
            String sql="select * from account where username ='"+username+"' and password ='"+pwd+"'";
            System.out.println(sql+"---sql");
            resultSet = statement.executeQuery(sql);
            boolean next = false;
            while(resultSet.next()){
                int aid = resultSet.getInt("aid");
                String usernamea = resultSet.getString("username");
                String pwda = resultSet.getString("password");
                int money = resultSet.getInt("money");
                account=new Account(aid,usernamea,pwda,money);
                System.out.println(account);
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
        return account;
    }
}
