package com.gavin.controller;

import com.gavin.mapper.BookstoreMapper;
import com.gavin.pojo.Bookstore;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Controller
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class ControllerDemo {

  @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    @Qualifier(value="sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * @return 返回查询到的书籍信息
     */


    @RequestMapping(value ="/controller.do" ,method= RequestMethod.GET)
    public Object searchBookById(HttpServletRequest req, HttpServletResponse resp ) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String bookid = req.getParameter("bookid");
        int i = 0;
        if (null != bookid & "" != bookid) {
            try {
                i = Integer.parseInt(bookid);
            } catch (Exception e) {
                i = 1001;
            }
        }
        BookstoreMapper mapper = sqlSession.getMapper(BookstoreMapper.class);
        Bookstore bookstore = mapper.selectByBookId(i);
        ModelAndView model = new ModelAndView();
        model.addObject("bookInfo", bookstore);
        model.setViewName("book.jsp");
     sqlSession.close();
        return model;


    }
}
