package com.zyp.dao;

import com.zyp.pojo.Dept;

import java.util.List;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/22 - 11 - 22 - 15:47
 * @Description: com.zyp.dao
 * @version: 1.0
 */
public interface DeptDao {
    /**
     * 查询全部门的方法
     * @return Dept对象封装的List集合
     */
    List<Dept> findAll();
    int addDept(Dept dept);
}
