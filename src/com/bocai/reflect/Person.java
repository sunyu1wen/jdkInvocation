package com.bocai.reflect;

/**
 * @author Bocai
 * @version V1.0
 * @ClassName: ${file_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Date ${date} ${time}
 */
public class Person {
    public String addres = "sun route";
    String name = "name1";
    Integer age = 24;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        this.name = "123";
        this.age = 1;
    }

    public String sayHello() {
        System.out.println("==Person say hello=12313==");
        return "Person say hello  wa ha ha!";
    }
}
