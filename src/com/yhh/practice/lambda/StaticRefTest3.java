package com.yhh.practice.lambda;

import java.util.Arrays;

/**
 * 1.引用静态方法 StaticRefTest3::cmp
 * 2.引用实例方法 String::compareTo  compareTo(String o)
 * 实际上有隐含的this参数，compareTo(String this,String o)
 * 3.
 * @author hyh
 * @date 2024/4/26
 */
public class StaticRefTest3 {
    public static void main(String[] args) {
        String[] array = new String[]{ "Apple", "Orange", "Banana", "Lemon"};

//        Arrays.sort(array, (s1,s2)->{return s1.compareToIgnoreCase(s2);});
        Arrays.sort(array, StaticRefTest3::cmp);
//        Arrays.sort(array, String::compareTo);
        System.out.println(String.join(",", array));
    }
    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }
}
