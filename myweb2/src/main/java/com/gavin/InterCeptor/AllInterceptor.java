package com.gavin.InterCeptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllInterceptor implements HandlerInterceptor {

        /**
         * @param request  请求
         * @param response 回应
         * @param handler  handler选择要执行的处理程序，用于类型和/或实例计算
         * @return 返回false, 则不会向下继续执行 默认是不做拦截处理的
         * @throws Exception
         * @desc 该方法会在控制器方法前执行，其返回值表示是否中断后续操作
         */


        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            return false;
        }


        /**
         * @param request      请求
         * @param response     回应
         * @param handler      handler选择要执行的处理程序，用于类型和/或实例计算
         * @param modelAndView 处理程序返回的modelAndView
         * @throws Exception
         * @desc 该方法会在控制器方法调用之后，且解析视图之前执行。
         * 可以通过此方法对请求域中的模型和视图做出进一步的修改
         */
        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        }

        /**
         *    *@desc 该方法在整个请求完成，即视图渲染结束之后执行。
         *    可以通过此方法实现一些资源清理、记录日志信息等工作。
         * @param response 当前HTTP响应
         * @param handler 启动异步的处理程序执行，用于类型和/或实例检查
         * @param请求当前HTTP请求
         * @exception
         */
        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        }
}
