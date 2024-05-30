package com.yhh.practice.collection;

import java.util.Arrays;
import java.util.List;

/**
 * List练习题
 *
 * @author hyh
 * @date 2024/4/26
 */
public class List1Test {
    public static void main(String[] args) {
        Integer[] arr = {10, 11, 12, 13, 14, 15, 16, 18, 19, 20};
        List<Integer> list = Arrays.asList(arr);
        int start = list.get(0), end = list.get(list.size() - 1);
/*
        for (int i = 1, j = list.size() - 2; i < list.size(); i++, j--) {
            if (++start != list.get(i)) {
                System.out.println(start);
                break;
            }
            if (--end != list.get(j)) {
                System.out.println(end);
                break;
            }
        }*/
        // 等差数列
        int totalSum = ((start + end) * (end - start + 1)) / 2;
        int listSum = 0;
        for (int i : list) {
            listSum += i;
        }
        int res = totalSum - listSum;
    }
}
