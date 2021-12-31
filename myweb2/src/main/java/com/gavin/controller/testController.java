package com.gavin.controller;


import com.gavin.mapper.UserMapper;
import com.gavin.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

//@RestController
@Controller
public class testController {
    @GetMapping(value = "/toInfo.do/{id}")
    public String toGET(@PathVariable("id") Integer id) {
        System.out.println("get" + id);
        return "GetSuccess";
    }

    @PostMapping("/toInfo.do/{id}")
    public String toPost(@PathVariable("id") Integer id) {
        System.out.println("post" + id);
        return "PostSuccess";
    }

    @PutMapping("/toInfo.do/{id}")
    public String toPut(@PathVariable("id") Integer id) {
        System.out.println("put" + id);
        return "PutSuccess";
    }

    @DeleteMapping("/toInfo.do/{id}")
    public String toDel(@PathVariable("id") Integer id) {
        System.out.println("del" + id);
        return "DelSuccess";
    }

    @RequestMapping("/testVoid.do")
    public void testVoid() {
        System.out.println("testVoid");
    }


    @RequestMapping("/testForward.do")
    public String testForward() {
        System.out.println("testForward");

        return "1234.jsp";
    }

    @RequestMapping("/testForward1.do")
    public String testForward1() {
        System.out.println("testForward1");
        return "/1234.jsp";
    }

    @RequestMapping("/testRedirect.do")
    public String testRedirect() {
        System.out.println("testForward1");
        return "redirect:1234.jsp";
    }

    @RequestMapping("/viewForward.do")
    public Object viewForward(HttpServletRequest request) {
        System.out.println("viewForward");
        ModelAndView model = new ModelAndView();
//      model.setViewName("1234.jsp");
//        model.setViewName("redirect:1234.jsp");

        // model.setView(new InternalResourceView("/1234.jsp"));
        model.setView(new RedirectView(request.getContextPath() + "/1234.jsp"));
        return model;
    }


    @RequestMapping("/viewForward1.do")
    public View viewForward1(HttpServletRequest request) {
        View view = null;
        System.out.println("viewForward1");
//        请求转发
//     view= new InternalResourceView("/1234.jsp");
//     重定向
        view = new RedirectView(request.getContextPath() + "/1234.jsp");
        return view;
    }


    @Qualifier
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @RequestMapping("/searchUser.do")
    @ResponseBody
    public User searchUser(@RequestParam("name") String name,@RequestParam("pwd") String pwd) {
        System.out.println(name+pwd);
     User user= new User(88,"gavin","pwd","");
        return user;
    }
    @RequestMapping("/searchUserDemo.do")
    public User searchUser() {
     User user= new User(88,"gavin","pwd","");
        return user;
    }

    @RequestMapping("/searchUserd.do")
    @ResponseBody
    public User searchUserd(@RequestBody User users) {
        System.out.println(users);
     User user= new User(88,"gavin","pwd","");
        return users;
    }

}
