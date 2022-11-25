package com.zyp.test1;

import org.apache.log4j.Logger;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/24 - 11 - 24 - 1:05
 * @Description: com.zyp.test1
 * @version: 1.0
 */
public class TestLog4j {
    //这是一个main方法，是程序的入口:
    public static void main(String[] args) {
        //1字符串一般传入一个类的全路径名
        //2传入一个类的字节码其实就是根据类的字节码自动获取类的全路径名
        //Logger logger =  Logger.getLogger("com.zyp.dao.impl.EmpDaoImpl");
        Logger logger =  Logger.getLogger(TestLog4j.class);
        logger.fatal("fatal message wei---");
        logger.error("error message wei---");
        logger.warn("warn message wei---");
        logger.info("infor message wei---");
        logger.debug("debug message wei---");
        try {
            int i =1/0;
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("程序捕获到了异常 wei---",e);
        }

    }
}
