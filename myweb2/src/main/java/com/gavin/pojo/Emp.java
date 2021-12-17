package com.gavin.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * emp
 * @author 
 */
@Data
public class Emp implements Serializable {
    private Integer EMPNO;

    private String ENAME;

    private String JOB;

    private Integer MGR;

    private Date HIREDATE;

    private Integer SAL;

    private Integer COMM;

    private Integer DEPTNO;

    private static final long serialVersionUID = 1L;
}