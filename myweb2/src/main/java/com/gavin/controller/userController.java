package com.gavin.controller;


import com.gavin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class userController {

@RequestMapping("/testJson.do")//这里映射加上
   @ResponseBody//先测试一下如果是简单的类型
    public User testJson(@RequestBody User user){

        System.out.println(user);
        return user;
    }
    @RequestMapping("/testJson1.do")//这里映射加上
   @ResponseBody//先测试一下如果是简单的类型
    public void testJson(@RequestBody String name,@RequestBody String pwd){

        System.out.println(name+pwd);
       // return name+pwd;
    }

    @RequestMapping("/testJson2.do")//这里映射加上
    public Object testJson1(@RequestBody String name){
        System.out.println(name);
        return "toReq.jsp";
    }

}
