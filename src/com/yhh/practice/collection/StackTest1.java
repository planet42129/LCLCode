package com.yhh.practice.collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 把一个int整数12500转换为十六进制表示的字符串
 *
 * @author hyh
 * @date 2024/5/1
 */
public class StackTest1 {
    public static void main(String[] args) {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    public static String toHex(int number) {
        Deque<Character> stack = new LinkedList<>();
        char[] chs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (number != 0) {
            int n = number % 16;
            stack.push(chs[n]);
            number = number / 16;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c: stack) {
           sb.append(c);
        }
        return sb.toString();
    }
}
