package com.yhh.practice.lambda;

import java.util.Arrays;
import java.util.Comparator;

/** 题目：排序
 * 知识点1：new一个Comparator的匿名类，重写Comparator中的compare方法，在这里自定义排序规则
 * 知识点2：调用Arrays.sort(array, Comparator的匿名类)，将要排序的数组和匿名类传进来
 * @author hyh
 * @date 2024/4/26
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        String[] array = new String[]{ "Apple", "Orange", "Banana", "Lemon"};
/*        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });*/
//        Arrays.sort(array, (s1,s2)->{return s1.compareTo(s2);});

        //代码提示说(s1,s2)->{return s1.compareTo(s2);}可以用String::compareTo代替
        // 因为自定义的规则(s1,s2)->{return s1.compareTo(s2);}和String类提供的方法一样
        Arrays.sort(array, String::compareTo);
        System.out.println(String.join(",", array));
    }
}
