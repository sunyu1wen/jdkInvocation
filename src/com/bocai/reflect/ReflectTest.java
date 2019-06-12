package com.bocai.reflect;

import org.junit.Test;
import sun.rmi.runtime.Log;

import java.io.InputStream;

/**
 * @author Bocai
 * @version V1.0
 * @ClassName: ${file_name}
 * @Description: ${todo}(类反射测试)
 * @Date ${date} ${time}
 */
public class ReflectTest {
public static void main(String args[]){
   // testClass();
}
@Test
public void testClass() throws ClassNotFoundException ,IllegalAccessException,InstantiationException{
    Class clazz = null;
    //Function1,通过类名
    clazz = Person.class;
    //function2 通过对象名，
    //这种方式用在传入一个对象，却不知道对象类型啥时候使用
    Person person = new Person("name2333",18);
    clazz = person.getClass();
    System.out.println(clazz.getName());
    //但是上面这个的意义不大，因为已经知道person类型是Person类，再这样写就没有必要了
    //如果传进来是一个Object类，这种做法就是应该的
    Object obj = new Person("name666",29);
    clazz = obj.getClass();
    System.out.println(clazz.getName());

    //function3 通过全类名
    String className = "com.bocai.reflect.Person";
    clazz = Class.forName(className);
    System.out.println(clazz.getName());
    System.out.println( clazz.getClassLoader());
    System.out.println( clazz.getClassLoader().getParent());
    System.out.println( clazz.getClassLoader().getParent().getParent());
    //1
    clazz.newInstance();
    Object []args = {"Name",10};
    clazz.getName();
    clazz.getSuperclass();
    clazz.getInterfaces();
    clazz.getClassLoader();

}
@Test
public void testClassLoaderAsStream(){
    InputStream in =  this.getClass().getClassLoader().getResourceAsStream("testFile.fxml");
    System.out.println(in.toString());
}
}
