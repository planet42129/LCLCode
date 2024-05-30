package com.yhh.practice.basic;

/**
 * @author hyh
 * @date 2024/5/30
 */
public class CharAndString {
    public static void main(String[] args) {
        // 请将下面一组int值视为字符的Unicode码，把它们拼成一个字符串：
        int a = 72;
        int b = 105;
        int c = 65281;

        String s = "" + (char) a + (char) b + (char) c;
        System.out.println(s);

        char a1 = (char)a;
        char b1 = (char)b;
        char c1 = (char)c;
        String s1 = String.valueOf(a1) + String.valueOf(b1) + String.valueOf(c1);
        System.out.println(s1);

        String s2 = String.valueOf(a1) + b1 + c1;
        System.out.println(s2);
    }
}
