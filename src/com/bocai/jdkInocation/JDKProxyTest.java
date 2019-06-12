package com.bocai.jdkInocation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author Bocai
 * @version V1.0
 * @ClassName: ${file_name}
 * @Description: ${todo}(JDK动态代理)
 * @Date ${date} ${time}
 */
public class JDKProxyTest {
    public  static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> proxyClass = Proxy.getProxyClass(JDKProxyTest.class.getClassLoader(),HelloWorld.class);
        final Constructor<?> cons = proxyClass.getConstructor(InvocationHandler.class);//反射机制获取代理类的构造方法
        //将自定义的InvocationHandler实例对象作为参数传入，通过构造方法获取代理对象
        final InvocationHandler ih = new MyInvocationHandler(new HelloWorldImpl());
        HelloWorld helloWorld = (HelloWorld)cons.newInstance(ih);
        System.out.println("helloWorld:");
        helloWorld.sayHello();

//        Proxy.newProxyInstance();
        //简单写法
        HelloWorld helloWorld1 = (HelloWorld)Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(),
                new Class<?>[]{HelloWorld.class},//这里是interface接口类
                new MyInvocationHandler(new HelloWorldImpl2()));

        HelloWorld helloWorld2= (HelloWorld)Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(),
                HelloWorldImpl2.class.getInterfaces(),//这里是实现类的getInterface方法
                new MyInvocationHandler(new HelloWorldImpl2()));
        helloWorld2.sayHello();
    }
}


/*
* 1:实现InvocationHandler接口来定义自己的代理类
* 通过Proxy类的getProxyClass方法来获取代理类
* 通过反射机制获取代理类的构造方法，方法签名为getConstructor(InvocationHandler.class)
* 2：将自己的实现的代理类作为参数传入，通过构造方法获取代理对象
* 3：代理对象调用目标方法
* 动态代理：在程序运行时，运用反射机制动态创建而成。
* */