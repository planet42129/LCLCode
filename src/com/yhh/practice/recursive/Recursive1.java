package com.yhh.practice.recursive;

/**
 * 求x的n次方
 *
 * @author hyh
 * @date 2024/5/1
 */
public class Recursive1 {
    public static void main(String[] args) {
//        System.out.println(mySqrt(2,3));
        System.out.println(mySqrtRecursive(2, 3));
    }

    public static int mySqrt(int x, int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = res * x;
        }
        return res;
    }

    /**
     * 求x的n次方
     * 递归算法的时间复杂度=递归的次数 * 每次递归中的操作次数
     * 所以下面的代码的时间复杂度是O(n),
     * 这个代码的时间复杂度等于第一个版本mySqrt的时间复杂度，并没有提升
     *
     * @param x
     * @param n
     * @return
     */
    public static int mySqrtRecursive(int x, int n) {
        if (n == 1) return x;
        /*
        int res = mySqrtRecursive(x, n-1) * x;
        return res;
        */
        return mySqrtRecursive(x, n) * x;
    }

    public static int mySqrtRecursive2(int x, int n) {
        if (n == 0) return 1;//n的0次方等于1
        return mySqrtRecursive2(x, n) * x;
    }

    public static int mySqrtRecursive3(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 1) {
            return mySqrtRecursive3(x, n/2) * mySqrtRecursive3(x, n/2) *x;
        }
        return mySqrtRecursive3(x, n/2) * mySqrtRecursive3(x, n/2);
    }

}

