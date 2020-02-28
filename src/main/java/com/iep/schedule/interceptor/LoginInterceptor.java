package com.iep.schedule.interceptor;

import com.iep.schedule.service.RedisOperator;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: zbw
 * @date: 2019/11/15 20:34
 * @description: 拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisOperator redisOperator;

    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String cookieDemo = request.getHeader("cookie");
        //如果用户未登陆过，前端传过来的是一个空字符串
        if (cookieDemo.equals("")) {
            //用户未登陆过，返回false
            return false;
        } else {
            return true;
        }
    }
}
