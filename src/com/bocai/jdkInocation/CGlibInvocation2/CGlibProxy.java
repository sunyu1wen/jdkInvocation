package com.bocai.jdkInocation.CGlibInvocation2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Bocai
 * @version V1.0
 * @ClassName: ${file_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Date ${date} ${time}
 */
public class CGlibProxy implements MethodInterceptor {


    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz) {
           return (T) Enhancer.create(clazz, this);
         }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(" before ");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(" after ");
        return  result;
    }

}
