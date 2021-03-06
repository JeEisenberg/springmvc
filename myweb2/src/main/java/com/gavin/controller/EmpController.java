package com.gavin.controller;

import com.gavin.mapper.EmpMapper;
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

@Controller
public class EmpController {
    @Qualifier
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

@RequestMapping("/toSearch.do")
    public String toSearch(){
        return "searchEmp.jsp";
    }



    @RequestMapping("/searchEmpByDept.do")
    public Object searchEmpByDept(Emp emp) {

        System.out.println(emp.getEMPNO());
        System.out.println(emp.getENAME());
        System.out.println(emp.getDept().getLoc());

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = mapper.selectEmpByEmpInfo(emp);
ModelAndView modelAndView= new ModelAndView();
modelAndView.addObject("empinfo",emp1);
modelAndView.setViewName( "empInfo.jsp");
        System.out.println(emp1);
        sqlSession.close();
        return modelAndView;
    }
}
