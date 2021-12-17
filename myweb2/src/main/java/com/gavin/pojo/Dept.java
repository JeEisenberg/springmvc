package com.gavin.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * dept
 * @author 
 */
@Data
public class Dept implements Serializable {
    private Integer deptno;

    private String dname;

    private String loc;

    private List<Emp> empOfDept;
    private static final long serialVersionUID = 1L;
}