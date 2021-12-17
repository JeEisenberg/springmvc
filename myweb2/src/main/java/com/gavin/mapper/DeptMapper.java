package com.gavin.mapper;

import com.gavin.pojo.Dept;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptMapper {

    Dept selectEmpBydeptno(Integer deptno);

  
}