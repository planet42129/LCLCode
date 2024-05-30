package com.yhh.practice.reflect;

import java.lang.reflect.Field;

/**
 * @author hyh
 * @date 2024/5/3
 */
public class AccessFieldTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String name = "Xiao Ming";
        int age = 20;
        Person1 p = new Person1();
        // TODO: 利用反射给name和age字段赋值:
        Class cls = p.getClass();
        Field f1 = cls.getDeclaredField("name");
        f1.setAccessible(true);
        f1.set(p, name);

        Field f2 = cls.getDeclaredField("age");
        f2.setAccessible(true);
        f2.set(p, age);

        System.out.println(p.getName()); // "Xiao Ming"
        System.out.println(p.getAge()); // 20
    }
}

class Person1 {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
