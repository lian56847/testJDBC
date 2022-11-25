package com.zyp.pojo;

import java.io.Serializable;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/22 - 11 - 22 - 15:45
 * @Description: com.zyp.pojo
 * @version: 1.0
 */
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

    public Dept() {
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Dept(Integer deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
}
