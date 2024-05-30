//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3505 👎 0


package com.yhh.leetcode.editor.cn;

public class Q0070ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Q0070ClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/*
第几阶  有几种方法
1       1     1
2       2          1+1    2
3       3     1+2  1+1+1  2+1
4       5          1+1+2  2+2   1+2+1  1+1+1+1  2+1+1
dp数组及下标含义： 到达第i层有dp[i]种方法
递推公式：dp[i]=d[i-2]+dp[i-1]
dp数组初始化：dp[1]=1; dp[2]=2
遍历顺序：从前往后
打印dp数组：

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

压缩版本：空间复杂度变为O(1),不用数组来存放
    public int climbStairs(int n) {
       if (n <= 2) return n;
       int a = 1, b = 2, c = 0;
        for (int i = 3; i <= n ; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
 */