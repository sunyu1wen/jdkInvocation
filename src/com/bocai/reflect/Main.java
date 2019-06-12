package com.bocai.reflect;

import java.lang.reflect.*;

/**
 * @author Bocai
 * @version V1.0
 * @ClassName: ${file_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Date ${date} ${time}
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        //返回A的构造方法
        Person person = Person.class.newInstance();
        Constructor con = Person.class.getConstructor();
        //返回A类的所有为public 声明的构造方法
        Constructor[] cons = Person.class.getConstructors();
        //返回A类所有的构造方法，包括private
        Constructor[] cons2 = Person.class.getDeclaredConstructors();
        //返回A类的第一个public 方法
        Method m = Person.class.getMethod("sayHello");
        //执行
        Object result =  m.invoke(person);
        System.out.println(result);
        m.invoke(Person.class.newInstance(),null);
        //返回A类所有的public 方法
        Method[] ms = Person.class.getMethods();
        //返回A类所有的方法，包括private
        Method[] mas = Person.class.getDeclaredMethods();
        //返回A类的public字段
        Field field = Person.class.getField("addres");

        Field[] fields = Person.class.getFields();

    }
}
