package com.gavin.controller;


import com.gavin.mapper.UserMapper;
import com.gavin.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class userController {

    @Qualifier
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    SqlSession sqlSession = null;


    //    请求  跳转到登陆页面
    @RequestMapping("/toLogin.do")
    public Object toLogin() {
        return "index.jsp";
    }

    HttpSession session = null;

    //登录检查
    @RequestMapping(value = "/toLoginIn.do", method = RequestMethod.POST)
    public String login(HttpServletRequest req) {
//        如果user不为null,说明已经登陆过
        session = req.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null) {
            return "forward:/WEB-INF/welcome.jsp";
        }
//user 为null 则判断登录是否符合条件
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
    /*    System.out.println(name + pwd);*/

        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
  /*      System.out.println(mapper);*/

        Integer integer = mapper.searchUser(name, pwd);
     /*   System.out.println(integer);*/

//        用户存在
        if (null != integer) {
           User userInfo = new User();
            userInfo.setName(name);
            userInfo.setPwd(pwd);
            this.session = req.getSession();
            this.session.setAttribute("user", userInfo);
            return "forward:/WEB-INF/welcome.jsp";

        }

        this.session.setAttribute("Info", "用户名或密码错误,请重新输入");
        sqlSession.close();
        return "redirect:index.jsp";
    }

    @RequestMapping("/logout.do")
    public String logout() {
        session.invalidate();
        return "index.jsp";
    }

    @RequestMapping("/testJson.do")//这里映射加上
    @ResponseBody//先测试一下如果是简单的类型
    public User testJson(@RequestBody User user) {

        System.out.println(user);
        return user;
    }

    @RequestMapping("/testJson1.do")//这里映射加上
    @ResponseBody//先测试一下如果是简单的类型
    public void testJson(@RequestBody String name, @RequestBody String pwd) {

        System.out.println(name + pwd);
        // return name+pwd;
    }

    @RequestMapping("/testJson2.do")//这里映射加上
    public Object testJson1(@RequestBody String name) {
        System.out.println(name);
        return "/dataOne/toReq.jsp";
    }

    @RequestMapping("/testInterceptor.do")
    public String testInterceptor() {
        System.out.println("hello world");
        return "WEB-INF/1234.jsp";
    }


}
