package com.gavin.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * emp
 * @author gavin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable {
    private Integer EMPNO;

    private String ENAME;

    private String JOB;

    private Integer MGR;

    private Date HIREDATE;

    private Integer SAL;

    private Integer COMM;

    private Integer DEPTNO;

    private  Dept dept;

    private static final long serialVersionUID = 1L;
}