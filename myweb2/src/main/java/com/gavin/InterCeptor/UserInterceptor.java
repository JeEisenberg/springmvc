package com.gavin.InterCeptor;

import com.gavin.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle--invoked");

//      检查登陆地址是否符合要求,不能直接去请求别的资源
        //要放行的请求资源
        String requestURI = request.getRequestURI();
//        放行一
        int i = requestURI.indexOf("/toLogin.do");
        if(i>=0){
            return true;
        }
//        放行二
        int i1 = requestURI.indexOf("/toLoginIn.do");
        if(i1>=0){
            return true;
        }
//还有一种情况 已经登陆了 放行三
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        if(null!=user){
            return true;
        }
//        剩下的直接拦截然后   登录页
        request.setAttribute("Info","请先登录!");
       response.sendRedirect("index.jsp");

        //request.getRequestDispatcher("index.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle--invoked");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion--invoked");
    }
}
