package com.gavin.controller;

import com.gavin.mapper.BookstoreMapper;
import com.gavin.mapper.UserMapper;
import com.gavin.pojo.Bookstore;
import com.gavin.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class ControllerDemo1 {


    /**
     * @return 返回查询到的书籍信息
     */


    @RequestMapping(value = "/controller1.do", method = RequestMethod.GET)
    public Object searchBookById(Integer bid, @RequestParam(value = "book_id") Integer id, Model model) {
        model.addAttribute("msg", id);
        model.addAttribute("message", bid);
//        参数处理
        return "book.jsp";


    }


    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    @Qualifier(value = "sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @RequestMapping(value = "/register.do")
    public String register() {
        return "register.jsp";
    }

    @RequestMapping("/RegisterUser.do")
    public Object regUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(user.getName());
        System.out.println(user);
        mapper.addUser(user);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("user",user.getName());
        modelAndView.setViewName("welcome.jsp");
        return modelAndView;
    }
}
