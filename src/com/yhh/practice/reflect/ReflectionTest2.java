package com.yhh.practice.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author hyh
 * @date 2024/5/3
 */
public class ReflectionTest2 {
    public static void main(String[] args) throws NoSuchFieldException {


        //利用反射拿到类的字段实例Field
/*
        Class stdClass = Student.class;
        Field score = stdClass.getField("score");
        System.out.println("score = " + score);
        Field name = stdClass.getField("name");
        System.out.println("name = " + name);
        Field grade = stdClass.getDeclaredField("grade");
        System.out.println("grade = " + grade);
        System.out.println(grade.getName());
        System.out.println(grade.getType());
        int modifiers = grade.getModifiers();
        System.out.println(Modifier.isPrivate(modifiers));
*/


    }
}

class Student extends Person {
    public int score;
    private int grade;
}

class Person {
    public String name;

}
