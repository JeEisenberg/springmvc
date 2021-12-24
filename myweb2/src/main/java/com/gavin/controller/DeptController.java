package com.gavin.controller;

import com.gavin.mapper.DeptMapper;
import com.gavin.pojo.Dept;
import com.gavin.pojo.Emp;
import com.gavin.pojo.addDeptInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
            model.addObject("deptInfo", empOfDept);
            model.setViewName("/dataOne/deptInfo.jsp");
            sqlSession.close();
            return model;
        }
        return null;
    }

    @RequestMapping(value ="/DeptNo.do/{deptno}",method = RequestMethod.GET)
    @ResponseBody
    public Object searchByDeptno1(@PathVariable("deptno") Integer deptno) {
        if (deptno != null) {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
            Dept dept = mapper.selectEmpBydeptno(deptno);
            sqlSession.close();
            return dept;
        }
        return null;
    }


    @RequestMapping("/toAdd.do")
    public String toAdd(){
        return "/dataOne/addDeptInfo.jsp";
    }


    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    @RequestMapping("/addDept.do")
    public Object addDept( addDeptInfo deptList,Model model){

        List<Dept> deptList1 = deptList.getDeptList();
//检查获得的参数
        for (Dept dept:deptList1
        ) {
            System.out.println(dept);
        }
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        int i = mapper.addDept(deptList);
        model.addAttribute("num",i);
        return "/dataOne/addSuccessInfo.jsp";
    }
}
