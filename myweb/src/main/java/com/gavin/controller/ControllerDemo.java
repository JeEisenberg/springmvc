package com.gavin.controller;

import com.gavin.pojo.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControllerDemo  implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    /*    String username = request.getParameter("name");
        String password=request.getParameter("pwd");

*/

            ModelAndView modelAndView= new ModelAndView();
            User user= new User();
            user.setName("张三");
            user.setPwd("123456");
            modelAndView.addObject("userinfo",user);
            modelAndView.setViewName("HelloWorld.jsp");

           return modelAndView;

    }
}
