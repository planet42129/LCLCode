package com.yhh.practice.exception;

/**
 * @author hyh
 * @date 2024/4/30
 */
public class ExceptionTest1 {
    public static void main(String[] args) {
        String a = "12";
        String b = "X9";
        // TODO: 捕获异常并处理
        int c = 0;
        int d = 0;
        try {
            c = stringToInt(a);
            d = stringToInt(b);
            System.out.println(c * d);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            System.out.println("END!");
        }
    }

    static int stringToInt(String s) {
        return Integer.parseInt(s);
    }
}
