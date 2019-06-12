package com.bocai.jdkInocation.CGlibInvocation;

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
public class CglibBookFacade implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }
    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz) {
        return (T) Enhancer.create(clazz, this);
    }

    /**
     *
     * @param o    代理类本身
     * @param method 标识拦截的方法
     * @param objects  入参
     * @param methodProxy  cglib方法
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("=======intercept start======");//增强后
        methodProxy.invokeSuper(o, objects);//这里是通过cglib方法来  间接  调用父类的方法 ，完成整个类的方法调用
        System.out.println("=======intercept end======");
        return null;
    }


}
