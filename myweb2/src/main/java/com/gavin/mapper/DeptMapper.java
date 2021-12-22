package com.gavin.mapper;

import com.gavin.pojo.Dept;
import com.gavin.pojo.addDeptInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptMapper {

    Dept selectEmpBydeptno(Integer deptno);

    int addDept(addDeptInfo deptList);


}