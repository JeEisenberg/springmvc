package com.gavin.test;

import com.gavin.mapper.DeptMapper;
import com.gavin.pojo.Dept;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    @Test
    public void test(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("springMybatisconfig.xml");
        DeptMapper deptMapper = ac.getBean("deptMapper", DeptMapper.class);
        Dept dept = deptMapper.selectByPrimaryKey(10);
        System.out.println(dept);
    }
}
