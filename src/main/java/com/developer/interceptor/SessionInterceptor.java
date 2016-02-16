package com.developer.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiao.lai on 16/1/9.
 */
public class SessionInterceptor implements MethodInterceptor{
    /**
     *
     * 对具体的方法尽心操作，这里可以拿到访问的参数，以及返回的参数，可以快速定位
     *
     * */
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("进入方法拦截器...............................");

        Object args = invocation.getArguments();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return invocation.proceed();
    }
}
