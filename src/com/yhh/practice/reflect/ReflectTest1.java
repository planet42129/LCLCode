package com.yhh.practice.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author hyh
 * @date 2024/5/2
 */
public class ReflectTest1 {
    public static void main(String[] args) {
        //通过Class实例对象获取类信息的方法称为反射
        //如何获取一个类的Class实例？
        //方法1：通过这个类的静态变量class获取
        Class<String> stringClass = String.class;
        System.out.println("stringClass = " + stringClass);

        //方法2：通过这个类的实例对象的getClass()方法获取
        String s2 = new String("hello");
        Class<? extends String> aClass = s2.getClass();

        Class<?> aClass1 = null;
        //方法3：如果知道这个类的完整类名，通过静态方法Class.forName()获取
        try {
             aClass1 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

/*

        //这个类由JVM创建的对应的Class实例对象是唯一的，可以用==验证
        System.out.println(stringClass == aClass);//true
        System.out.println(aClass == aClass1);//true
*/
//        printClassInfo(String[].class);
        printClassInfo(int.class);

    }

    public static void printClassInfo(Class cls) {
/*        String clsName = cls.getName();
        System.out.println("clsName = " + clsName);
        String superName = cls.getSuperclass().getName();
        System.out.println("superName = " + superName);
        Class[] interfaces = cls.getInterfaces();
        for (Class interface1:
             interfaces) {
            System.out.println("implements interface1 = " + interface1);
        }
        for (Method method : cls.getMethods()) {
            System.out.println("method = " + method);
        }
        for (Field field : cls.getFields()) {
            System.out.println("field = " + field);
        }*/
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}
