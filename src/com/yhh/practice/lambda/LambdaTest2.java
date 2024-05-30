package com.yhh.practice.lambda;

import java.util.Arrays;
import java.util.Comparator;

/** 题目：忽略大小写再排序
 * s1.compareToIgnoreCase(s2)
 * @author hyh
 * @date 2024/4/26
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        String[] array = new String[]{ "Apple", "Orange", "banana", "Lemon"};
/*        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });*/
        Arrays.sort(array, (s1,s2)->{return s1.compareToIgnoreCase(s2);});
        System.out.println(String.join(",", array));
    }
}
