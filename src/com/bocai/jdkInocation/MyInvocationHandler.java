package com.bocai.jdkInocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Bocai
 * @version V1.0
 * @ClassName: ${file_name}
 * @Description: ${todo}(InvocationHandler【代理对象】和【目标对象】自定义中间类必须实现的接口；)
 * 方法public Object invoke；在这个方法中，Proxy通过newProxyInstance方法创建代理对象，method表示目标对象被调用的方法，args表示目标对象被调用方法的形参列表
 * @Date ${date} ${time}
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object myTarget;//属于被代理的目标对象

    public MyInvocationHandler(Object target){
        this.myTarget = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method:"+method.getName()+" is Invocked");
        return method.invoke(myTarget,args);//执行相应目标的方法；
    }
}
