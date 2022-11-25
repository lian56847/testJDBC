package com.zyp.dao.impl;

import com.zyp.dao.BaseDao;
import com.zyp.dao.DeptDao;
import com.zyp.pojo.Dept;
import com.zyp.pojo.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/22 - 11 - 22 - 15:48
 * @Description: com.zyp.dao.impl
 * @version: 1.0
 */
public class DeptDaoImpl extends BaseDao implements DeptDao {

    @Override
    public List<Dept> findAll() {
        String sql="select * from dept ";
        return baseQuery(Dept.class,sql);
    }

    @Override
    public int addDept(Dept dept) {
        String sql="insert into dept values(? ,?,? )";
        return baseUpdate(sql,dept.getDeptno(),dept.getDname(),dept.getLoc());
    }
}
