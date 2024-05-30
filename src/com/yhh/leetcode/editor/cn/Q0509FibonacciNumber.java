//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
//
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 752 👎 0


package com.yhh.leetcode.editor.cn;

import java.util.Scanner;

public class Q0509FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new Q0509FibonacciNumber().new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution.fib(n);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*
1、dp数组及其下标的含义
dp：代表数列数组                 0 1 1 2 3 5 8 13 ...
i： 下标代表数列数组的下标索引  0 1 2 3 4 5 6 7 ...
2、递推公式
i = 0时，dp[0] = 0
i = 1时，dp[1] = 1
i > 1时，dp[i] = dp[i-1] + dp[i-2]
3、dp数组如何初始化
int[] dp = new int[n + 1];
4、遍历顺序
for (int i = 0; i <= n; i++) {
    if (i == 0 || i == 1) {
         dp[i] = i;
    } else {
         dp[i] = dp[i - 1] + dp[i - 2];
    }
}
5、打印dp数组
for (int i = 0; i <= n; i++) {
   System.out.println("dp[" + i + "] = " + dp[i]);
}

        public int fib(int n) {
            int[] dp = new int[n + 1];
            // 直接给下标0和下标1赋值是错误的，万一方法参数的n等于0或1呢
            // dp[0] = 0;
            // dp[1] = 1;
            for (int i = 0; i <= n; i++) {
                if (i == 0 || i == 1) {
                    dp[i] = i;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
            // 打印dp数组
            // for (int i = 0; i <= n; i++) {
            //     System.out.println("dp[" + i + "] = " + dp[i]);
            // }
            return dp[n];
        }
 */

/* 递归法解决
   public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }*/

/*carl
确定dp[i]及i的含义：dp[i]  第i个斐波那契数的数值为dp[i]
递推公式：dp[i]=dp[i-1]+dp[i-2]
dp数组如何初始化：dp[0] = 0; dp[1] = 1;
遍历顺序：从前向后遍历
打印dp数组：用来debug

        public int fib(int n) {
            if (n <= 1) return n;
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            // 打印dp数组
            // for (int i = 0; i <= n; i++) {
            //     System.out.println("dp[" + i + "] = " + dp[i]);
            // }
            return dp[n];
        }

最终：
        public int fib(int n) {
            if (n <= 1) return n;
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

压缩版本：
        public int fib(int n) {
            if (n <= 1) return n;
            int a = 0, b = 1, c = 0;
            for (int i = 2; i <= n ; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return b;
        }
 */