package com.gavin.mapper;

import com.gavin.pojo.Emp;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpMapper {


    Emp selectEmpByEmpInfo (Emp emp);
}