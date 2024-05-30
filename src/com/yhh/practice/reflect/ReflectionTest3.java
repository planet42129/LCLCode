package com.yhh.practice.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hyh
 * @date 2024/5/3
 */
public class ReflectionTest3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
/*        String s = "hello,world";
//        System.out.println(s.substring(6));
        Class<String> cls = String.class;
        // 获取String substring(int)方法，参数为int类型
        Method m = cls.getDeclaredMethod("substring", int.class);
        String res = (String) m.invoke(s, 0,6);
        System.out.println(res);*/

        Method m = Integer.class.getDeclaredMethod("parseInt", String.class);
        Integer res2 = (Integer)m.invoke(null, "1");
        System.out.println(res2);

    }
}
