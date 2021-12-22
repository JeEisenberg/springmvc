package com.gavin.pojo;

import com.gavin.pojo.Dept;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class addDeptInfo {
    private List<Dept> deptList;
}
