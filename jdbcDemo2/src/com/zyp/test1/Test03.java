package com.zyp.test1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/23 - 11 - 23 - 23:38
 * @Description: com.zyp.test1
 * @version: 1.0
 */
public class Test03 {
    //这是一个main方法，是程序的入口:
    public static void main(String[] args) {
        Properties properties=new Properties();
        InputStream inputStream = Test03.class.getResourceAsStream("/jdbc.properties");//jdbc.properties
        System.out.println("inputStream = " + inputStream);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String password = properties.getProperty("password");
        System.out.println("password wei--- = " + password);
        String user = properties.getProperty("user");
        System.out.println("user wei--- = " + user);
        String initSize = properties.getProperty("initSize");
        System.out.println("initSize wei---= " + initSize);
        String maxSize = properties.getProperty("maxSize");
        System.out.println("maxSize wei---= " + maxSize);
        String driver = properties.getProperty("driver");
        System.out.println("driver wei---= " + driver);
        String url = properties.getProperty("url");
        System.out.println("url wei---= " + url);
    }
}
