package com.zyp.dao.impl;

import com.zyp.dao.BaseDao;
import com.zyp.dao.EmpDao;
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
public class EmpDaoImpl extends BaseDao implements EmpDao {
    @Override
    public int addEmp(Emp emp) {
        String sql="insert into emp values(DEFAULT ,?,?,?,?,?,?,?)";
        return baseUpdate(sql, emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno());
    }

    @Override
    public int deleteByEmpno(int empno) {
        String sql="delete from emp where empno =?";
        return baseUpdate(sql, empno);
    }

    @Override
    public List<Emp> findAll() {
        String sql="select * from emp ";
        return baseQuery(Emp.class,sql);
    }

    @Override
    public int updateEmp(Emp emp) {
        String sql="update emp set ename =? ,job=?, mgr =?,hiredate =?,sal=?,comm=?,deptno=? where empno =?";
        return baseUpdate(sql, emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno());
    }


}
