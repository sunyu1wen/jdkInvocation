package com.bocai.jdkInocation.CGlibInvocation2;

/**
 * @author Bocai
 * @version V1.0
 * @ClassName: ${file_name}
 * @Description: ${todo}(之前使用cglib3.0报错异常版本冲突；使用2.2.2目前正常)
 * @Date ${date} ${time}
 */
public class TestCgblib {
    public static void main(String[] args) {
        CGlibProxy cGlibProxy = new CGlibProxy();
        HelloImp helloProxy = (HelloImp) cGlibProxy.getProxy(HelloImp.class);
        helloProxy.say("Bob");

    }
}
