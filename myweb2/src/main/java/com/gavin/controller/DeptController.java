package com.gavin.controller;

import com.gavin.mapper.DeptMapper;
import com.gavin.pojo.Dept;
import com.gavin.pojo.Emp;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DeptController {

    @Qualifier
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @RequestMapping(value = "/searchByDeptNo.do" ,params = "deptno")
    public Object searchByDeptno(@RequestParam("deptno") Integer deptno) {

        if (deptno != null) {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
            Dept dept = mapper.selectEmpBydeptno(deptno);
            List<Emp> empOfDept = dept.getEmpOfDept();
            ModelAndView model = new ModelAndView();
            model.addObject("empInfo", empOfDept);
            model.setViewName("deptInfo.jsp");
            return model;
        }
        return null;
    }
}
