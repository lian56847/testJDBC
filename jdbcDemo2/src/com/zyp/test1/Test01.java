package com.zyp.test1;

import com.zyp.dao.EmpDao;
import com.zyp.dao.impl.EmpDaoImpl;
import com.zyp.pojo.Emp;

import java.util.Date;


/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/22 - 11 - 22 - 16:28
 * @Description: com.zyp.test1
 * @version: 1.0
 */
public class Test01 {
    //这是一个main方法，是程序的入口:
    public static void main(String[] args) {
        EmpDao empDao = new EmpDaoImpl();
       /* Emp emp = new Emp(null,"苏格兰","MANAGE",7839,new Date(),3055.2,1000.3,30);
        int i = empDao.addEmp(emp);
        System.out.println(i+"---i");*/
        int i = empDao.deleteByEmpno(7938);
        System.out.println(i+"---i");
    }
}
