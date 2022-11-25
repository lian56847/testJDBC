package com.zyp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/23 - 11 - 23 - 23:54
 * @Description: com.zyp.util
 * @version: 1.0
 */
public class PropertiesUtil {
    private Properties properties;

    public PropertiesUtil(String path){
        properties=new Properties();
        InputStream inputStream = this.getClass().getResourceAsStream(path);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperties(String key){
        return properties.getProperty(key);
    }
}
